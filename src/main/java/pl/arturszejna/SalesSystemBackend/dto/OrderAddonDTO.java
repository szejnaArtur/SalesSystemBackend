package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.OrderAddon;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderAddonDTO {

    private Long idOrderAddon;
    private Integer amount;
    private AddonDTO addonDTO;
    private OrderItemDTO orderItemDTO;

    private OrderAddonDTO(Long idOrderAddon, Integer amount, AddonDTO addonDTO, OrderItemDTO orderItemDTO) {
        setIdOrderAddon(idOrderAddon);
        setAmount(amount);
        setAddonDTO(addonDTO);
        setOrderItemDTO(orderItemDTO);
    }

    public static OrderAddonDTO of(OrderAddon orderAddon) {
        return new OrderAddonDTO(orderAddon.getIdOrderAddon(), orderAddon.getAmount(),
                AddonDTO.of(orderAddon.getAddon()), OrderItemDTO.of(orderAddon.getOrderItem()));
    }

    public static List<OrderAddonDTO> of(List<OrderAddon> orderItemList) {
        List<OrderAddonDTO> orderAddonDTOList = new ArrayList<>();
        for (OrderAddon orderAddon : orderItemList) {
            orderAddonDTOList.add(OrderAddonDTO.of(orderAddon));
        }
        return orderAddonDTOList;
    }
}
