package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDto;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;
import pl.arturszejna.SalesSystemBackend.service.MenuItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menuItems")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping(value = "/add")
    public MenuItem add(@RequestBody MenuItem newMenuItem){
        return menuItemService.add(newMenuItem);
    }

    @GetMapping(value = "/findAll")
    public List<MenuItemDto> findAll(){
        return menuItemService.findAll();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity delete(@RequestBody Long idMenuItem){
        return menuItemService.delete(idMenuItem);
    }

}
