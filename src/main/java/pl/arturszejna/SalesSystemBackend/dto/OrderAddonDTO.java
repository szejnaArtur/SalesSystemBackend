package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;

@Data
public class OrderAddonDTO {

    private Long idOrderAddon;
    private Integer amount;
    private AddonDTO addonDTO;
    private OrderItemDTO orderItemDTO;

}
