package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Category;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {

    private Long idCategory;
    private String name;

    private CategoryDTO(Long idCategory, String name) {
        setIdCategory(idCategory);
        setName(name);
    }

    public static CategoryDTO of(Category category) {
        return new CategoryDTO(category.getIdCategory(), category.getName());
    }

    public static List<CategoryDTO> of(List<Category> categoryList) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDTOList.add(CategoryDTO.of(category));
        }
        return categoryDTOList;
    }

}
