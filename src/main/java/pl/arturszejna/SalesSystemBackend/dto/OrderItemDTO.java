package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

@Data
public class OrderItemDTO {

    private Long idOrderItem;
    private MenuItemDTO menuItemDTO;
    private Integer quantity;

    public static OrderItemDTO of(OrderItem orderItem){
        OrderItemDTO dto = new OrderItemDTO();
        dto.setIdOrderItem(orderItem.getIdOrderItem());
        dto.setQuantity(orderItem.getQuantity());
        dto.setMenuItemDTO(MenuItemDTO.of(orderItem.getMenuItem()));
        return dto;
    }

}
