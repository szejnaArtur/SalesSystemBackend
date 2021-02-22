package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemTypeDTO;
import pl.arturszejna.SalesSystemBackend.entity.MenuItemType;
import pl.arturszejna.SalesSystemBackend.repository.MenuItemTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuItemTypeService {

    private final MenuItemTypeRepository menuItemTypeRepository;

    public List<MenuItemTypeDTO> findAll() {
        return MenuItemTypeDTO.of(menuItemTypeRepository.findAll());
    }

    public MenuItemTypeDTO findByName(String name) {
        Optional<MenuItemType> optionalType = menuItemTypeRepository.findByName(name);
        return optionalType.map(MenuItemTypeDTO::of).orElse(null);
    }

}
