package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;
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
        OrderItem orderItem = OrderItem.of(orderItemDTO);
        orderItemRepository.save(orderItem);
        return orderItemDTO;
    }

    public List<OrderItemDTO> saveAll(List<OrderItemDTO> orderItemsDTO){
        List<OrderItem> orderItems = orderItemsDTO.stream().map(OrderItem::of).collect(Collectors.toList());
        orderItemRepository.saveAll(orderItems);
        return orderItemsDTO;
    }
}
