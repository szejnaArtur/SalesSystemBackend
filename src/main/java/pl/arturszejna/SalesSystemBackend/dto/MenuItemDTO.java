package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;
import pl.arturszejna.SalesSystemBackend.entity.MenuItemType;

@Data
public class MenuItemDTO {

    private Long idMenuItem;
    private String name;
    private Double price;
    private Integer kcal;
    private String description;
    private MenuItemTypeDTO type;

    public static MenuItemDTO of(MenuItem menuItem){
        MenuItemDTO dto = new MenuItemDTO();
        dto.setIdMenuItem(menuItem.getIdMenuItem());
        dto.setName(menuItem.getName());
        dto.setPrice(menuItem.getPrice());
        dto.setKcal(menuItem.getKcal());
        dto.setDescription(menuItem.getDescription());
        dto.setType(MenuItemTypeDTO.of(menuItem.getType()));
        return dto;
    }
}
