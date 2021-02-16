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
    @JoinColumn(name = "idOrderBill")
    private OrderBill orderBill;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMenuItem")
    private MenuItem menuItem;

    public static OrderItem of(OrderItemDTO dto){
        OrderItem orderItem = new OrderItem();
        orderItem.setIdOrderItem(dto.getIdOrderItem());
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setMenuItem(MenuItem.of(dto.getMenuItemDTO()));
        orderItem.setOrderBill(OrderBill.of(dto.getOrderBillDTO()));
        return orderItem;
    }
}
