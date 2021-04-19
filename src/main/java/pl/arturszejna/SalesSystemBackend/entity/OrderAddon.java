package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.OrderAddonDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class OrderAddon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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
        setIdOrderAddon(idOrderAddon);
        setAmount(amount);
        setAddon(addon);
        setOrderItem(orderItem);
    }

    public OrderAddon() {

    }

    public static OrderAddon of(OrderAddonDTO dto) {
        return new OrderAddon(dto.getIdOrderAddon(), dto.getAmount(),
                Addon.of(dto.getAddonDTO()), OrderItem.of(dto.getOrderItemDTO()));
    }

    public static List<OrderAddon> of(List<OrderAddonDTO> dtoList) {
        List<OrderAddon> orderAddonList = new ArrayList<>();
        for (OrderAddonDTO dto : dtoList) {
            orderAddonList.add(OrderAddon.of(dto));
        }
        return orderAddonList;
    }
}
