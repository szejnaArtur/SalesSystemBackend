package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
