package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.*;
import pl.arturszejna.SalesSystemBackend.entity.Bill;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.repository.BillRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {

    public final BillRepository billRepository;
    public final EmployeeService employeeService;


    public List<BillDTO> findAll() {
        return BillDTO.of(billRepository.findAll());
    }

    public BillDTO findById(Long id) {
        Optional<Bill> optionalBill = billRepository.findById(id);
        return optionalBill.map(BillDTO::of).orElse(null);
    }

    public BillDTO save(BillDTO billDTO) {
        Bill bill = billRepository.save(Bill.of(billDTO));
        Employee employee = employeeService.findById(billDTO.getEmployeeDTO().getIdEmployee());
        bill.setEmployee(employee);
        billRepository.save(bill);
        return billDTO;
    }

    private List<CheckDTO> findAllWithDateTimeAfter(LocalDateTime localDateTime) {
        return CheckDTO.of(billRepository.findAllWithDateTimeAfter(localDateTime));
    }

    public List<AverageBillAmountDTO> createAGCRaport() {
        LocalDate now = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth(), 0, 0);

        List<CheckDTO> allWithDateTimeAfter = findAllWithDateTimeAfter(localDateTime);
        List<AverageBillAmountDTO> averageBillAmountDTOS = new ArrayList<>();
        boolean employeeFound = false;

        for (CheckDTO check : allWithDateTimeAfter) {
            EmployeeDTO employee = check.getEmployeeDTO();
            double amount = 0;

            for (OrderItemDTO orderItem : check.getOrderItemDTOList()) {
                amount = amount + (orderItem.getAmount() * orderItem.getMenuItemDTO().getPrice() - orderItem.getDiscount());
            }

            if (averageBillAmountDTOS.size() == 0) {
                averageBillAmountDTOS.add(new AverageBillAmountDTO(employee, amount));
            } else {
                for (AverageBillAmountDTO averageBillAmountDTO : averageBillAmountDTOS) {
                    if (averageBillAmountDTO.getEmployeeDTO().getIdEmployee().equals(employee.getIdEmployee())) {
                        averageBillAmountDTO.setNumberOfTransactions(averageBillAmountDTO.getNumberOfTransactions() + 1);
                        averageBillAmountDTO.setAmount(averageBillAmountDTO.getAmount() + amount);
                        employeeFound = true;
                        break;
                    }
                }
                if (!employeeFound) {
                    averageBillAmountDTOS.add(new AverageBillAmountDTO(employee, amount));
                }
                employeeFound = false;
            }
        }
        return averageBillAmountDTOS;
    }

}
