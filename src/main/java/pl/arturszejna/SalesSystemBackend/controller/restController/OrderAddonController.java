package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.OrderAddonDTO;
import pl.arturszejna.SalesSystemBackend.service.OrderAddonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orderAddons")
public class OrderAddonController {

    private final OrderAddonService orderAddonService;

    @PostMapping("/addAll")
    public List<OrderAddonDTO> saveAll(@RequestBody List<OrderAddonDTO> orderAddonDTOList) {
        orderAddonService.saveAll(orderAddonDTOList);
        return orderAddonDTOList;
    }

}
