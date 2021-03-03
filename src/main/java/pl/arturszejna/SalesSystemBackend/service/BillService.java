package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.BillDTO;
import pl.arturszejna.SalesSystemBackend.entity.Bill;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.repository.BillRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {

    public final BillRepository billRepository;
    public final EmployeeService employeeService;


    public List<BillDTO> findAll(){
        return BillDTO.of(billRepository.findAll());
    }

    public BillDTO findById(Long id){
        Optional<Bill> optionalBill = billRepository.findById(id);
        return optionalBill.map(BillDTO::of).orElse(null);
    }

    public BillDTO save(BillDTO billDTO){
        Bill bill = billRepository.save(Bill.of(billDTO));
        Employee employee = employeeService.findById(billDTO.getEmployeeDTO().getIdEmployee());
        bill.setEmployee(employee);
        billRepository.save(bill);
        return billDTO;
    }

}
