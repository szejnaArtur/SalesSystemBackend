package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long idOrderItem;
    private MenuItemDTO menuItemDTO;
    private Integer quantity;

}
