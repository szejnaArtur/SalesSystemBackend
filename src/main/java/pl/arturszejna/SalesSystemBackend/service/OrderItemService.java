package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;
import pl.arturszejna.SalesSystemBackend.entity.MenuItemType;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;
import pl.arturszejna.SalesSystemBackend.repository.OrderItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final MenuItemTypeService menuItemTypeService;

    public OrderItemDTO save(OrderItemDTO orderItemDTO) {
        MenuItemType type = menuItemTypeService.findByName(orderItemDTO.getMenuItemDTO().getType());
        OrderItem orderItem = OrderItem.of(orderItemDTO, type);
        orderItemRepository.save(orderItem);
        return orderItemDTO;
    }

    public List<OrderItemDTO> saveAll(List<OrderItemDTO> orderItemsDTO){
        List<OrderItem> orderItems = orderItemsDTO.stream().map(x -> {
            MenuItemType type = menuItemTypeService.findByName(x.getMenuItemDTO().getType());
            return OrderItem.of(x, type);
        }).collect(Collectors.toList());
        orderItemRepository.saveAll(orderItems);
        return orderItemsDTO;
    }
}
