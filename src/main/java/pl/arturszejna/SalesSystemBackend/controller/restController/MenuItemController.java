package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDto;
import pl.arturszejna.SalesSystemBackend.service.MenuItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menuItems")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping(value = "/add")
    public MenuItemDto add(@RequestBody MenuItemDto newMenuItem) {
        return menuItemService.saveOrUpdate(newMenuItem);
    }

    @GetMapping(value = "/findAll")
    public List<MenuItemDto> findAll() {

        return menuItemService.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public MenuItemDto findById(@PathVariable Long id) {
        return menuItemService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        return menuItemService.delete(id);
    }

}