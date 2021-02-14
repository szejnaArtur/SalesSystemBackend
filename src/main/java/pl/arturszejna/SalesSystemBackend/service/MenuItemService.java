package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDTO;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;
import pl.arturszejna.SalesSystemBackend.repository.MenuItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemTypeService menuItemTypeService;

    public MenuItemDTO saveOrUpdate(MenuItemDTO newMenuItem) {
        if (newMenuItem.getIdMenuItem() == null) {
            menuItemRepository.save(MenuItem.of(newMenuItem));
            return newMenuItem;
        } else {
            Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(newMenuItem.getIdMenuItem());
            if (optionalMenuItem.isPresent()) {
                MenuItem menuItem = optionalMenuItem.get();
                menuItem.update(newMenuItem);
                return MenuItemDTO.of(menuItemRepository.save(menuItem));
            } else {
                throw new RuntimeException("Can't find menu item with given id: " + newMenuItem.getIdMenuItem());
            }
        }
    }

    public List<MenuItemDTO> findAll() {
        return menuItemRepository.findAll()
                .stream()
                .map(MenuItemDTO::of)
                .collect(Collectors.toList());
    }

    public MenuItemDTO findById(Long idMenuItem) {
        Optional<MenuItem> optionalDto = menuItemRepository.findById(idMenuItem);
        return optionalDto.map(MenuItemDTO::of).orElse(null);
    }

    public ResponseEntity delete(Long idMenuItem) {
        menuItemRepository.deleteById(idMenuItem);
        return ResponseEntity.ok().build();
    }
}
