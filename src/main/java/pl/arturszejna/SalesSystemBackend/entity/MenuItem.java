package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.MenuItemDto;

import javax.persistence.*;

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

    @Column
    private String type;

    public static MenuItem of(MenuItemDto newMenuItem) {
        MenuItem dto = new MenuItem();
        dto.setName(newMenuItem.getName());
        dto.setPrice(newMenuItem.getPrice());
        dto.setKcal(newMenuItem.getKcal());
        dto.setDescription(newMenuItem.getDescription());
        dto.setType(newMenuItem.getType());
        return dto;
    }

    public void update(MenuItemDto dto) {
        this.setName(dto.getName());
        this.setPrice(dto.getPrice());
        this.setKcal(dto.getKcal());
        this.setDescription(dto.getDescription());
        this.setType(dto.getType());
    }
}
