package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;

@Data
public class MenuItemDTO_GET {

    private Long idMenuItem;
    private String name;
    private Double price;
    private Integer kcal;
    private String description;
    private MenuItemTypeDTO type;

    private MenuItemDTO_GET(Long idMenuItem, String name, Double price, Integer kcal,
                            String description, MenuItemTypeDTO type) {
        setIdMenuItem(idMenuItem);
        setName(name);
        setPrice(price);
        setKcal(kcal);
        setDescription(description);
        setType(type);
    }

    public static MenuItemDTO_GET of(MenuItem menuItem) {
        return new MenuItemDTO_GET(menuItem.getIdMenuItem(), menuItem.getName(), menuItem.getPrice(), menuItem.getKcal(),
                menuItem.getDescription(), MenuItemTypeDTO.of(menuItem.getType()));
    }

}
