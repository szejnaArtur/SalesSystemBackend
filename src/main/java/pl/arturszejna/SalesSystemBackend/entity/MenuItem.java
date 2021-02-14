package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDTO;

import javax.persistence.*;
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

    public static MenuItem of(MenuItemDTO dto) {
        MenuItem menuItem = new MenuItem();
        menuItem.setIdMenuItem(dto.getIdMenuItem());
        menuItem.setName(dto.getName());
        menuItem.setPrice(dto.getPrice());
        menuItem.setKcal(dto.getKcal());
        menuItem.setDescription(dto.getDescription());
        menuItem.setType(MenuItemType.of(dto.getType()));
        return menuItem;
    }

    public void update(MenuItemDTO dto) {
        setIdMenuItem(dto.getIdMenuItem());
        setName(dto.getName());
        setPrice(dto.getPrice());
        setKcal(dto.getKcal());
        setDescription(dto.getDescription());
        setType(MenuItemType.of(dto.getType()));

    }
}
