package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByBill_IdBill(Long id);

    @Query(value = "select * from order_item order by id_order_item desc limit 10", nativeQuery = true)
    List<OrderItem> findLastRecords();

    @Query("select o from OrderItem o where o.bill.orderDate >= :dateTime")
    List<OrderItem> findAllWithDateTimeAfter(@Param("dateTime") LocalDateTime creationDateTime);
}
