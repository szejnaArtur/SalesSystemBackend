package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;
import pl.arturszejna.SalesSystemBackend.repository.BillRepository;
import pl.arturszejna.SalesSystemBackend.repository.OrderItemRepository;
import pl.arturszejna.SalesSystemBackend.service.OrderItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orderItems")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private final OrderItemRepository orderItemRepository;
    private final BillRepository billRepository;

    @GetMapping("/findAll")
    public List<OrderItemDTO> findAll() {
        return orderItemService.findAll();
    }

    @GetMapping("/findOrderItem/{id}")
    public List<OrderItemDTO> findByIdBill(@PathVariable Long id) {
        return orderItemService.findByIdBill(id);
    }

    @PostMapping("/addAll")
    public List<OrderItemDTO> saveAll(@RequestBody List<OrderItemDTO> orderItemDTOList) {
        orderItemService.saveAll(orderItemDTOList);
        return orderItemDTOList;
    }
}
