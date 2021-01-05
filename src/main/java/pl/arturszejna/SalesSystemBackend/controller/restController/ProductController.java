package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.arturszejna.SalesSystemBackend.entity.Product;
import pl.arturszejna.SalesSystemBackend.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping("/add")
    public Product addItem(@RequestBody Product product){
        return productService.add(product);
    }

    @GetMapping("/findAll")
    public List<Product> findAllItem(){
        return productService.findAll();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteItem(@RequestBody Long idItem){
        productService.delete(idItem);
        return ResponseEntity.ok().build();
    }
}