package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.OrderAddon;
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
    private List<OrderAddonDTO> orderAddonDTOList;

    private OrderItemDTO(Long idOrderItem, Integer amount, MenuItemDTO menuItemDTO, BillDTO billDTO, Double discount,
                         List<OrderAddonDTO> orderAddonDTOList) {
        this.idOrderItem = idOrderItem;
        this.amount = amount;
        this.menuItemDTO = menuItemDTO;
        this.billDTO = billDTO;
        this.discount = discount;
        this.orderAddonDTOList = orderAddonDTOList;
    }

    public OrderItemDTO() {}

    public static OrderItemDTO of(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getIdOrderItem(),
                orderItem.getAmount(),
                MenuItemDTO.of(orderItem.getMenuItem()),
                BillDTO.of(orderItem.getBill()),
                orderItem.getDiscount(),
                OrderAddonDTO.of(orderItem.getOrderAddonList()));
    }

    public static List<OrderItemDTO> of(List<OrderItem> orderItemList) {
        List<OrderItemDTO> dtoList = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            dtoList.add(OrderItemDTO.of(orderItem));
        }
        return dtoList;
    }
}
