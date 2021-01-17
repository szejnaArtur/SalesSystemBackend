package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDto;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;
import pl.arturszejna.SalesSystemBackend.repository.MenuItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemDto saveOrUpdate(MenuItemDto newMenuItem) {
        if (newMenuItem.getIdMenuItem() == null) {
            return MenuItemDto.of(menuItemRepository.save(MenuItem.of(newMenuItem)));
        } else {
            Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(newMenuItem.getIdMenuItem());
            if (optionalMenuItem.isPresent()) {
                MenuItem menuItem = optionalMenuItem.get();
                menuItem.update(newMenuItem);
                return MenuItemDto.of(menuItemRepository.save(menuItem));
            } else {
                throw new RuntimeException("Can't find menu item with given id: " + newMenuItem.getIdMenuItem());
            }
        }
    }

    private void update(MenuItemDto dto) {

    }

    public List<MenuItemDto> findAll() {
        return menuItemRepository.findAll()
                .stream()
                .map(MenuItemDto::of)
                .collect(Collectors.toList());
    }

    public MenuItemDto findById(Long idMenuItem) {
        Optional<MenuItem> optionalDto = menuItemRepository.findById(idMenuItem);
        return optionalDto.map(MenuItemDto::of).orElse(null);
    }

    public ResponseEntity delete(Long idMenuItem) {
        menuItemRepository.deleteById(idMenuItem);
        return ResponseEntity.ok().build();
    }
}
