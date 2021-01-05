package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDto;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;
import pl.arturszejna.SalesSystemBackend.repository.MenuItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItem add(MenuItem newMenuItem){
        return menuItemRepository.save(newMenuItem);
    }

    public List<MenuItemDto> findAll(){
        return menuItemRepository.findAll()
                .stream()
                .map(MenuItemDto::of)
                .collect(Collectors.toList());
    }

    public ResponseEntity delete (Long idMenuItem){
        menuItemRepository.deleteById(idMenuItem);
        return ResponseEntity.ok().build();
    }
}
