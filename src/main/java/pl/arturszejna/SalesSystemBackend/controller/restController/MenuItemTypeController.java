package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemTypeDTO;
import pl.arturszejna.SalesSystemBackend.service.MenuItemTypeService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menuItemType")
public class MenuItemTypeController {

    private final MenuItemTypeService menuItemTypeService;

    @GetMapping(value = "/findAll")
    public Set<MenuItemTypeDTO> findAll() {
        return menuItemTypeService.findAll();
    }

    @GetMapping(value = "/findByName/{name}")
    public MenuItemTypeDTO findByName(@PathVariable String name){
        return MenuItemTypeDTO.of(menuItemTypeService.findByName(name));
    }
}
