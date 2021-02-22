package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.OrderBillDTO;
import pl.arturszejna.SalesSystemBackend.service.OrderBillService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orderBills")
public class OrderBillController {

    private final OrderBillService orderBillService;

    @PostMapping(value = "/add")
    public OrderBillDTO add(@RequestBody OrderBillDTO orderBillDTO) {
        return orderBillService.addOrderBill(orderBillDTO);
    }

}
