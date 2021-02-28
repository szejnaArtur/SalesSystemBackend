package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenuItem;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Integer kcal;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idType")
    private MenuItemType type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menuItem")
    private List<OrderItem> orderItems;

    private MenuItem(Long idMenuItem, String name, Double price, Integer kcal, String description, MenuItemType type) {
        this.idMenuItem = idMenuItem;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
        this.description = description;
        this.type = type;
    }

    public MenuItem() {
    }

    public static MenuItem of(MenuItemDTO dto) {
        return new MenuItem(dto.getIdMenuItem(),
                dto.getName(),
                dto.getPrice(),
                dto.getKcal(),
                dto.getDescription(),
                MenuItemType.of(dto.getType()));
    }

    public static List<MenuItem> of(List<MenuItemDTO> dtoList) {
        List<MenuItem> newDtoList = new ArrayList<>();
        for (MenuItemDTO menuItemDTO : dtoList) {
            newDtoList.add(MenuItem.of(menuItemDTO));
        }
        return newDtoList;
    }
}
