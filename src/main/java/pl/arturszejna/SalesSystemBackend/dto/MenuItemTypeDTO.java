package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.MenuItemType;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuItemTypeDTO {

    private Long idType;
    private String name;

    private MenuItemTypeDTO(Long id, String name) {
        this.idType = id;
        this.name = name;
    }

    public static MenuItemTypeDTO of(MenuItemType type) {
        return new MenuItemTypeDTO(type.getIdType(), type.getName());
    }

    public static List<MenuItemTypeDTO> of(List<MenuItemType> all) {
        List<MenuItemTypeDTO> menuItemTypeDTOList = new ArrayList<>();
        for (MenuItemType menuItemType : all) {
            menuItemTypeDTOList.add(MenuItemTypeDTO.of(menuItemType));
        }
        return menuItemTypeDTOList;
    }
}
