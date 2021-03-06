package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemTypeDTO;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MenuItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private List<MenuItem> menuItems;

    public static MenuItemType of(MenuItemTypeDTO dto){
        MenuItemType menuItemType = new MenuItemType();
        menuItemType.setIdType(dto.getIdType());
        menuItemType.setName(dto.getName());
        return menuItemType;
    }

}
