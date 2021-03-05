package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByBill_IdBill(Long id);



//    SELECT * FROM restaurantsalessystem.order_item as item, restaurantsalessystem.bill as bill where item.id_bill = bill.id_bill and order_date like '2021-03-04%';
}
