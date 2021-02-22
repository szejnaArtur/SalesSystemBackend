package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.OrderItemDTO;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;
import pl.arturszejna.SalesSystemBackend.repository.OrderItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public List<OrderItemDTO> findAll() {
        List<OrderItem> all = orderItemRepository.findAll();
        return OrderItemDTO.of(all);
    }

}
