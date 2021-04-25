package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeDTO {

    private Long idRecipe;
    private Double quantity;
    //    private MenuItem menuItem;
    private ProductDTO product;

    private RecipeDTO(Long idRecipe, Double quantity, ProductDTO product){
        setIdRecipe(idRecipe);
        setQuantity(quantity);
        setProduct(product);
    }

    public static RecipeDTO of(Recipe recipe){
        return new RecipeDTO(recipe.getIdRecipe(), recipe.getQuantity(), ProductDTO.of(recipe.getProduct()));
    }

    public static List<RecipeDTO> of(List<Recipe> recipeList){
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        for (Recipe recipe : recipeList){
            recipeDTOList.add(RecipeDTO.of(recipe));
        }
        return recipeDTOList;
    }
}
