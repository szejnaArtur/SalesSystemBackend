package pl.arturszejna.SalesSystemBackend.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arturszejna.SalesSystemBackend.dto.RecipeDTO;
import pl.arturszejna.SalesSystemBackend.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/findBy/menuItem/Id/{id}")
    public List<RecipeDTO> findAllByMenuItem_IdMenuItem(@PathVariable Long id){
        return recipeService.findAllByMenuItem_IdMenuItem(id);
    }

    @GetMapping("/findBy/product/Id/{id}")
    public List<RecipeDTO> findAllByProduct_IdProduct(@PathVariable Long id){
        return recipeService.findAllByProduct_IdProduct(id);
    }
}
