package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.AverageBillAmountDTO;
import pl.arturszejna.SalesSystemBackend.dto.EmployeeDTO;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;
import pl.arturszejna.SalesSystemBackend.entity.Bill;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;
import pl.arturszejna.SalesSystemBackend.repository.BillRepository;
import pl.arturszejna.SalesSystemBackend.repository.OrderItemRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final BillService billService;
    private final BillRepository billRepository;

    public List<OrderItemDTO> findAll() {
        List<OrderItem> all = orderItemRepository.findAll();
        return OrderItemDTO.of(all);
    }

    public List<OrderItemDTO> findByIdBill(Long idBill) {
        return OrderItemDTO.of(orderItemRepository.findAllByBill_IdBill(idBill));
    }

    public void saveAll(List<OrderItemDTO> orderItemsDTO) {
        List<OrderItem> orderItemList = new ArrayList<>();
        billService.save(orderItemsDTO.get(0).getBillDTO());
        List<Bill> bills = billRepository.findAll();
        Bill newBill = bills.get(bills.size() - 1);
        for (OrderItemDTO orderItemDTO : orderItemsDTO) {
            OrderItem orderItem = createOrderItems(orderItemDTO);
            orderItem.setBill(newBill);
            orderItemList.add(orderItem);
        }
        orderItemRepository.saveAll(orderItemList);
    }

    public OrderItem createOrderItems(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        MenuItem menuItem = MenuItem.of(orderItemDTO.getMenuItemDTO());
        Bill bill = Bill.of(orderItemDTO.getBillDTO());
        Integer amount = orderItemDTO.getAmount();

        orderItem.setAmount(amount);
        orderItem.setMenuItem(menuItem);

        return orderItem;
    }

    private List<OrderItem> findAllByTodayDate() {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonth().getValue();
        int dayOfMonth = now.getDayOfMonth();
        return orderItemRepository.findAll()
                .stream()
                .filter(x -> dayOfMonth == x.getBill().getOrderDate().getDayOfMonth())
                .filter(x -> month == x.getBill().getOrderDate().getMonth().getValue())
                .filter(x -> year == x.getBill().getOrderDate().getYear())
                .collect(Collectors.toList());
    }

    //TODO This method can be done better. To improve
    public List<AverageBillAmountDTO> createAGCRaport() {
        List<OrderItem> orderItems = findAllByTodayDate();
        List<AverageBillAmountDTO> averageBillAmountDTOS = new ArrayList<>();
        boolean employeeFound = false;
        for (OrderItem orderItem : orderItems) {
            Employee employee = orderItem.getBill().getEmployee();
            double amount = orderItem.getAmount() * orderItem.getMenuItem().getPrice();

            if (averageBillAmountDTOS.size() == 0) {
                averageBillAmountDTOS.add(new AverageBillAmountDTO(EmployeeDTO.of(employee), amount));
            } else {
                for (AverageBillAmountDTO averageBillAmountDTO : averageBillAmountDTOS) {
                    if (averageBillAmountDTO.getEmployeeDTO().getIdEmployee().equals(employee.getIdEmployee())) {
                        averageBillAmountDTO.setNumberOfTransactions(averageBillAmountDTO.getNumberOfTransactions() + 1);
                        averageBillAmountDTO.setAmount(averageBillAmountDTO.getAmount() + amount);
                        employeeFound = true;
                        break;
                    }
                }
                if (!employeeFound){
                    averageBillAmountDTOS.add(new AverageBillAmountDTO(EmployeeDTO.of(employee), amount));
                }
                employeeFound = false;
            }
        }
        System.out.println(averageBillAmountDTOS.toString());
        return averageBillAmountDTOS;
    }

}
