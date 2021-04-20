package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;
import pl.arturszejna.SalesSystemBackend.entity.Bill;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;
import pl.arturszejna.SalesSystemBackend.repository.BillRepository;
import pl.arturszejna.SalesSystemBackend.repository.OrderItemRepository;

import java.util.ArrayList;
import java.util.List;

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

    public List<OrderItem> findLastRecord() {
        return orderItemRepository.findLastRecords();
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
        orderItem.setDiscount(orderItemDTO.getDiscount());

        return orderItem;
    }
}
