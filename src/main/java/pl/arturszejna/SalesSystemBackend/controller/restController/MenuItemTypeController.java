package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemTypeDTO;
import pl.arturszejna.SalesSystemBackend.service.MenuItemTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menuItemTypes")
public class MenuItemTypeController {

    private final MenuItemTypeService menuItemTypeService;

    @GetMapping(value = "/findAll")
    public List<MenuItemTypeDTO> findAll() {
        return menuItemTypeService.findAll();
    }

    @GetMapping(value = "/find/{name}")
    public MenuItemTypeDTO find(@PathVariable String name) {
        return menuItemTypeService.findByName(name);
    }

}
