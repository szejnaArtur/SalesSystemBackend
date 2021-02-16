package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.OrderBillDTO;
import pl.arturszejna.SalesSystemBackend.entity.OrderBill;
import pl.arturszejna.SalesSystemBackend.repository.OrderBillRepository;

@Service
@RequiredArgsConstructor
public class OrderBillService {

    private final OrderBillRepository orderBillRepository;

    public OrderBillDTO addOrderBill(OrderBillDTO orderBillDTO){
        return OrderBillDTO.of(orderBillRepository.save(OrderBill.of(orderBillDTO)));
    }

}
