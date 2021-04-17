package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByBill_IdBill(Long id);

    @Query(value = "select * from order_item order by id_order_item desc limit 10", nativeQuery = true)
    List<OrderItem> findLastRecords();

}
