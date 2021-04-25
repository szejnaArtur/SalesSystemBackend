package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.ProductDTO;
import pl.arturszejna.SalesSystemBackend.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/findAll")
    public List<ProductDTO> findAllItem() {
        return productService.findAll();
    }

    @GetMapping("/findBy/Category/Id/{id}")
    public List<ProductDTO> findAllByCategory_Id(@PathVariable Long id) {
        return productService.findAllByCategory_Id(id);
    }

    @GetMapping("/findBy/Category/Name/{name}")
    public List<ProductDTO> findAllByCategory_Name(@PathVariable String name){
        return productService.findAllByCategory_Name(name);
    }

}