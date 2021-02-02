package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.MenuItemType;

@Data
public class MenuItemTypeDTO {

    private Long idType;
    private String name;

    public static MenuItemTypeDTO of(MenuItemType menuItemType){
        MenuItemTypeDTO dto = new MenuItemTypeDTO();
        dto.setIdType(menuItemType.getIdType());
        dto.setName(menuItemType.getName());
        return dto;
    }
}
