package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderItemDTO {

    private Long idOrderItem;
    private Integer amount;
    private MenuItemDTO menuItemDTO;
    private BillDTO billDTO;
    private Double discount;

    private OrderItemDTO(Long idOrderItem, Integer amount, MenuItemDTO menuItemDTO, BillDTO billDTO, Double discount) {
        this.idOrderItem = idOrderItem;
        this.amount = amount;
        this.menuItemDTO = menuItemDTO;
        this.billDTO = billDTO;
        this.discount = discount;
    }

    public OrderItemDTO() {}

    public static OrderItemDTO of(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getIdOrderItem(),
                orderItem.getAmount(),
                MenuItemDTO.of(orderItem.getMenuItem()),
                BillDTO.of(orderItem.getBill()),
                orderItem.getDiscount());
    }

    public static List<OrderItemDTO> of(List<OrderItem> orderItemList) {
        List<OrderItemDTO> dtoList = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            dtoList.add(OrderItemDTO.of(orderItem));
        }
        return dtoList;
    }
}
