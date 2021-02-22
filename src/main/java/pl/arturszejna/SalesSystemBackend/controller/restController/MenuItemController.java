package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDTO;
import pl.arturszejna.SalesSystemBackend.service.MenuItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menuItems")
public class MenuItemController {

    private final MenuItemService menuItemService;

    //    @PostMapping(value = "/add")
//    public MenuItemDTO add(@RequestBody MenuItemDTO newMenuItem) {
//        return menuItemService.saveOrUpdate(newMenuItem);
//    }
//
    @GetMapping(value = "/findAll")
    public List<MenuItemDTO> findAll() {
        return menuItemService.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public MenuItemDTO findById(@PathVariable Long id) {
        return menuItemService.findById(id);
    }

//    @DeleteMapping(value = "/delete/{id}")
//    public ResponseEntity delete(@PathVariable Long id) {
//
//        return menuItemService.delete(id);
//    }

}
