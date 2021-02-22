package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/findAll")
    public List<OrderItemDTO> findAll(){
        return orderItemService.findAll();
    }

}
