package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Addon;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddonDTO {

    private Long idAddon;
    private Double price;
    private MenuItem menuItem;

    private AddonDTO(Long idAddon, Double price, MenuItem menuItem) {
        this.idAddon = idAddon;
        this.price = price;
        this.menuItem = menuItem;
    }

    private static AddonDTO of(Addon addon) {
        return new AddonDTO(addon.getIdAddon(), addon.getPrice(), addon.getMenuItem());
    }

    public static List<AddonDTO> of(List<Addon> addons) {
        List<AddonDTO> dtoList = new ArrayList<>();
        for (Addon addon : addons) {
            dtoList.add(AddonDTO.of(addon));
        }
        return dtoList;
    }
}
