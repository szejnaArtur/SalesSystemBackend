package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemTypeDTO;
import pl.arturszejna.SalesSystemBackend.entity.MenuItemType;
import pl.arturszejna.SalesSystemBackend.repository.MenuItemTypeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MenuItemTypeService {

    private final MenuItemTypeRepository menuItemTypeRepository;

    public Set<MenuItemTypeDTO> findAll(){
        Set<MenuItemTypeDTO> menuItemTypesDTO = new HashSet<>();
        for(MenuItemType menuItemType : menuItemTypeRepository.findAll()){
            menuItemTypesDTO.add(MenuItemTypeDTO.of(menuItemType));
        }
        return menuItemTypesDTO;
    }

}
