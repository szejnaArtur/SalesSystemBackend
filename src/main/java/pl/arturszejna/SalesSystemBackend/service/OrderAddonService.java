package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.dto.OrderAddonDTO;
import pl.arturszejna.SalesSystemBackend.entity.OrderAddon;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;
import pl.arturszejna.SalesSystemBackend.repository.OrderAddonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderAddonService {

    private final OrderAddonRepository orderAddonRepository;
    private final OrderItemService orderItemService;

    public void saveAll(List<OrderAddonDTO> orderAddonDTOList) {
        List<OrderAddon> orderAddonList = OrderAddon.of(orderAddonDTOList);
        List<OrderItem> lastRecords = orderItemService.findLastRecord();
        for (OrderAddon orderAddon : orderAddonList){
            for (OrderItem orderItem : lastRecords){
                if (orderAddon.getOrderItem().getMenuItem().getName().equals(orderItem.getMenuItem().getName())){
                    orderAddon.setOrderItem(orderItem);
                    break;
                }
            }
//            orderAddon.setOrderItem(lastRecord);
        }
        orderAddonRepository.saveAll(orderAddonList);
    }


}
