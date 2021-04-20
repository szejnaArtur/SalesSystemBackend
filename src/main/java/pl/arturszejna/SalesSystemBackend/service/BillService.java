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

    private List<BillDTO> findAllWithDateTimeAfter(LocalDateTime localDateTime) {
        return BillDTO.of(billRepository.findAllWithDateTimeAfter(localDateTime));
    }

    public List<AverageBillAmountDTO> createAGCRaport() {
        LocalDate now = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth(), 0, 0);

        List<BillDTO> allWithDateTimeAfter = findAllWithDateTimeAfter(localDateTime);
        List<AverageBillAmountDTO> averageBillAmountDTOList = new ArrayList<>();

        for (BillDTO bill : allWithDateTimeAfter) {
            EmployeeDTO employee = bill.getEmployeeDTO();
            double billAmount = bill.getCardPaymentAmount() + bill.getCashPaymentAmount()
                    + bill.getSodexoPaymentAmount() + bill.getPayUPaymentAmount();

            if (averageBillAmountDTOList.size() == 0 || !isEmployee(averageBillAmountDTOList, employee)) {
                averageBillAmountDTOList.add(new AverageBillAmountDTO(bill.getEmployeeDTO(), billAmount));
            } else {
                for (AverageBillAmountDTO averageBillAmountDTO : averageBillAmountDTOList){
                    if (averageBillAmountDTO.getEmployeeDTO().getIdEmployee().equals(employee.getIdEmployee())){
                        double totalCashierRevenue = averageBillAmountDTO.getAmount();
                        Integer numberOfTransactions = averageBillAmountDTO.getNumberOfTransactions();
                        averageBillAmountDTO.setAmount(totalCashierRevenue + billAmount);
                        averageBillAmountDTO.setNumberOfTransactions(numberOfTransactions + 1);
                        break;
                    }
                }
            }
        }
        return averageBillAmountDTOList;
    }

    private boolean isEmployee(List<AverageBillAmountDTO> averageBillAmountDTOList, EmployeeDTO employeeDTO){
        for (AverageBillAmountDTO averageBillAmountDTO : averageBillAmountDTOList){
            if (averageBillAmountDTO.getEmployeeDTO().getIdEmployee().equals(employeeDTO.getIdEmployee())){
                return true;
            }
        }
        return false;
    }

}
