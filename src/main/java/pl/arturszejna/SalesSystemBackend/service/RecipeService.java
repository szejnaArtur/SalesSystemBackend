package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.RecipeDTO;
import pl.arturszejna.SalesSystemBackend.repository.RecipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<RecipeDTO> findAllByMenuItem_IdMenuItem(Long id){
        return RecipeDTO.of(recipeRepository.findAllByMenuItem_IdMenuItem(id));
    }

    public List<RecipeDTO> findAllByProduct_IdProduct(Long id){
        return RecipeDTO.of(recipeRepository.findAllByProduct_IdProduct(id));
    }

}
