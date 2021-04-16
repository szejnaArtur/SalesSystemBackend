package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.OrderAddon;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

import java.util.List;

public interface OrderAddonRepository extends JpaRepository<OrderAddon, Long> {

}
