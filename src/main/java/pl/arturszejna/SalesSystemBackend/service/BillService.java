package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.BillDTO;
import pl.arturszejna.SalesSystemBackend.entity.Bill;
import pl.arturszejna.SalesSystemBackend.repository.BillRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {

    public final BillRepository billRepository;

    public List<BillDTO> findAll(){
        return BillDTO.of(billRepository.findAll());
    }

    public BillDTO findById(Long id){
        Optional<Bill> optionalBill = billRepository.findById(id);
        return optionalBill.map(BillDTO::of).orElse(null);
    }

    public BillDTO save(BillDTO billDTO){
        System.out.println(billDTO.getOrderDate().getHour() + " " + billDTO.getOrderDate().getMinute());
        return BillDTO.of(billRepository.save(Bill.of(billDTO)));
    }

}
