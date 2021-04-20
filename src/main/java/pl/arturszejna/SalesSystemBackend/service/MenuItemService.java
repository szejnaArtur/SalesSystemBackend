package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
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

    public List<MenuItemDTO> findAll() {
        return menuItemRepository.findAll()
                .stream()
                .map(MenuItemDTO::of)
                .collect(Collectors.toList());
    }

    public MenuItemDTO findById(Long idMenuItem) {
        Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(idMenuItem);
        return optionalMenuItem.map(MenuItemDTO::of).orElse(null);
    }

    public MenuItemDTO findByName(String name) {
        Optional<MenuItem> optional = menuItemRepository.findByName(name);
        return optional.map(MenuItemDTO::of).orElse(null);
    }
}
