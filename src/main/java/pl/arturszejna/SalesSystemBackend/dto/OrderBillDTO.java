package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.OrderBill;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderBillDTO {

    private Long idOrder;
    private List<OrderItemDTO> orderItems;
    private LocalDateTime orderDate;
    private LocalDateTime pickUpDate;

    public static OrderBillDTO of(OrderBill orderBill){
        OrderBillDTO dto = new OrderBillDTO();
        dto.setIdOrder(orderBill.getIdOrderBill());
        dto.setOrderDate(orderBill.getOrderDate());
        dto.setPickUpDate(orderBill.getPickUpDate());
        dto.setOrderItems(orderBill.getOrderItems().stream().map(OrderItemDTO::of).collect(Collectors.toList()));
        return dto;
    }

}
