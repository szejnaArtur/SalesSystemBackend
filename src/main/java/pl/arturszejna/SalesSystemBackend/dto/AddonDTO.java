package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Addon;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddonDTO {

    private Long idAddon;
    private Double price;
    private String name;

    private AddonDTO(Long idAddon, Double price, String name) {
        this.idAddon = idAddon;
        this.price = price;
        this.name = name;
    }

    private static AddonDTO of(Addon addon) {
        return new AddonDTO(addon.getIdAddon(), addon.getPrice(), addon.getName());
    }

    public static List<AddonDTO> of(List<Addon> addons) {
        List<AddonDTO> dtoList = new ArrayList<>();
        for (Addon addon : addons) {
            dtoList.add(AddonDTO.of(addon));
        }
        return dtoList;
    }
}
