package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.OrderBill;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

public interface OrderBillRepository extends JpaRepository<OrderBill, Long> {

}
