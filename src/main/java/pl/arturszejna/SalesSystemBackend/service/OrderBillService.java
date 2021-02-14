package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.repository.OrderBillRepository;

@Service
@RequiredArgsConstructor
public class OrderBillService {

    private final OrderBillRepository orderBillRepository;


}
