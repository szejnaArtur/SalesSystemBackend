package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeDTO {

    private Long idRecipe;
    private Double quantity;
    private MenuItemDTO_GET menuItem;
    private ProductDTO product;

    private RecipeDTO(Long idRecipe, Double quantity, ProductDTO product, MenuItemDTO_GET menuItem) {
        setIdRecipe(idRecipe);
        setQuantity(quantity);
        setProduct(product);
        setMenuItem(menuItem);
    }

    public static RecipeDTO of(Recipe recipe) {
        return new RecipeDTO(recipe.getIdRecipe(), recipe.getQuantity(), ProductDTO.of(recipe.getProduct()),
                MenuItemDTO_GET.of(recipe.getMenuItem()));
    }

    public static List<RecipeDTO> of(List<Recipe> recipeList) {
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        for (Recipe recipe : recipeList) {
            recipeDTOList.add(RecipeDTO.of(recipe));
        }
        return recipeDTOList;
    }
}
