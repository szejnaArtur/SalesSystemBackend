package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderItem;

    @Column
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMenuItem")
    private MenuItem menuItem;

    public static OrderItem of(OrderItemDTO orderItemDTO, MenuItemType type){
        OrderItem orderItem = new OrderItem();
        orderItem.setIdOrderItem(orderItemDTO.getIdOrderItem());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setMenuItem(MenuItem.of(orderItemDTO.getMenuItemDTO(), type));
        return orderItem;
    }
}
