package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;
import pl.arturszejna.SalesSystemBackend.service.OrderItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orderItems")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping(value = "/add")
    public OrderItemDTO add(@RequestBody OrderItemDTO orderItemDTO) {
        return orderItemService.save(orderItemDTO);
    }

    @PostMapping(value = "/addAll")
    public List<OrderItemDTO> addAll(@RequestBody List<OrderItemDTO> orderItemsDTO) {
        return orderItemService.saveAll(orderItemsDTO);
    }
}
