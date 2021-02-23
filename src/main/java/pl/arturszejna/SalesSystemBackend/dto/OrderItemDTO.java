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

    private OrderItemDTO(Long idOrderItem, Integer amount, MenuItemDTO menuItemDTO, BillDTO billDTO) {
        this.idOrderItem = idOrderItem;
        this.amount = amount;
        this.menuItemDTO = menuItemDTO;
        this.billDTO = billDTO;
    }

    public static OrderItemDTO of(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getIdOrderItem(),
                orderItem.getAmount(),
                MenuItemDTO.of(orderItem.getMenuItem()),
                BillDTO.of(orderItem.getBill()));
    }

    public static List<OrderItemDTO> of(List<OrderItem> orderItemList) {
        List<OrderItemDTO> dtoList = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            dtoList.add(OrderItemDTO.of(orderItem));
        }
        return dtoList;
    }
}
