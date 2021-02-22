package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.OrderBillDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class OrderBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderBill;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderBill")
    private List<OrderItem> orderItems;

    @Column
    private LocalDateTime orderDate;

    @Column
    private LocalDateTime pickUpDate;

    public static OrderBill of(OrderBillDTO dto){
        OrderBill orderBill = new OrderBill();
        orderBill.setIdOrderBill(dto.getIdOrder());
        orderBill.setOrderDate(dto.getOrderDate());
        orderBill.setPickUpDate(dto.getPickUpDate());
        orderBill.setOrderItems(dto.getOrderItems().stream().map(OrderItem::of).collect(Collectors.toList()));
        return orderBill;
    }
}
