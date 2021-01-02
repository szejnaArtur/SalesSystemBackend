package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.entity.Item;
import pl.arturszejna.SalesSystemBackend.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private ItemService itemService;

    @PostMapping("/add")
    public Item addItem(@RequestBody Item item){
        return itemService.add(item);
    }

    @GetMapping("/findAll")
    public List<Item> findAllItem(){
        return itemService.findAll();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteItem(@RequestBody Long idItem){
        itemService.delete(idItem);
        return ResponseEntity.ok().build();
    }
}