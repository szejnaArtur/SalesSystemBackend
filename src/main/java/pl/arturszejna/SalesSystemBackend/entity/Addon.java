package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.AddonDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddon;

    @Column
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMenuItem")
    private MenuItem menuItem;

    private Addon(Long idAddon, Double price, MenuItem menuItem){
        this.idAddon = idAddon;
        this.price = price;
        this.menuItem = menuItem;
    }

    public Addon() {

    }

    public static Addon of(AddonDTO dto){
        return new Addon(dto.getIdAddon(), dto.getPrice(), dto.getMenuItem());
    }

    public static List<Addon> of(List<AddonDTO> addonsDTO){
        List<Addon> dtoList = new ArrayList<>();
        for(AddonDTO dto : addonsDTO){
            dtoList.add(Addon.of(dto));
        }
        return dtoList;
    }

}
