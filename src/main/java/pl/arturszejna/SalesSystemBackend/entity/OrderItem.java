package pl.arturszejna.SalesSystemBackend.entity;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idOrderItem;

    @Column
    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMenuItem")
    private MenuItem menuItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBill")
    private Bill bill;

    @Column
    private Double discount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItem")
    private List<OrderAddon> orderAddonList;

    private OrderItem(Long idOrderItem, Integer amount, MenuItem menuItem, Bill bill, Double discount) {
        this.idOrderItem = idOrderItem;
        this.amount = amount;
        this.menuItem = menuItem;
        this.bill = bill;
        this.discount = discount;
    }

    public OrderItem() {
    }

    public static OrderItem of(OrderItemDTO dto) {
        return new OrderItem(dto.getIdOrderItem(),
                dto.getAmount(),
                MenuItem.of(dto.getMenuItemDTO()),
                Bill.of(dto.getBillDTO()),
                dto.getDiscount());
    }

    public static List<OrderItem> of(List<OrderItemDTO> orderItemDTOList) {
        List<OrderItem> dtoList = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderItemDTOList) {
            dtoList.add(OrderItem.of(orderItemDTO));
        }
        return dtoList;
    }

}
