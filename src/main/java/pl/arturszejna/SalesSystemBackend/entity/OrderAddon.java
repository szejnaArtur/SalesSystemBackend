package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.OrderAddonDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class OrderAddon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderAddon;

    @Column
    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAddon")
    private Addon addon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOrderItem")
    private OrderItem orderItem;

    private OrderAddon(Long idOrderAddon, Integer amount, Addon addon, OrderItem orderItem) {
        this.idOrderAddon = idOrderAddon;
        this.amount = amount;
        this.addon = addon;
        this.orderItem = orderItem;
    }

    public OrderAddon() {

    }

    public static OrderAddon of(OrderAddonDTO dto) {
        return new OrderAddon(dto.getIdOrderAddon(), dto.getAmount(), Addon.of(dto.getAddonDTO()),
                OrderItem.of(dto.getOrderItemDTO()));
    }

    public static List<OrderAddon> of(List<OrderAddonDTO> orderAddonDTOList) {
        List<OrderAddon> orderAddonList = new ArrayList<>();
        for (OrderAddonDTO orderAddonDTO : orderAddonDTOList) {
            orderAddonList.add(OrderAddon.of(orderAddonDTO));
        }
        return orderAddonList;
    }

}
