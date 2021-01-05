package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;

@Data
public class MenuItemDto {

    private Long idMenuItem;
    private String name;
    private Double price;
    private Integer kcal;
    private String description;
    private String type;

    public static MenuItemDto of(MenuItem menuItem){
        MenuItemDto dto = new MenuItemDto();
        dto.setIdMenuItem(menuItem.getIdMenuItem());
        dto.setName(menuItem.getName());
        dto.setPrice(menuItem.getPrice());
        dto.setKcal(menuItem.getKcal());
        dto.setDescription(menuItem.getDescription());
        dto.setType(menuItem.getType());
        return dto;
    }
}
