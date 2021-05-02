package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.entity.OrderItem;
import pl.arturszejna.SalesSystemBackend.entity.WorkHours;

import java.util.List;

public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {

    List<WorkHours> findAllByEmployee(Employee employee);

    List<WorkHours> findAllByEndWorkIsNull();

//    @Query(value = "select * from order_item order by id_order_item desc limit 1", nativeQuery = true)
//    List<OrderItem> findLastRecord();

}
