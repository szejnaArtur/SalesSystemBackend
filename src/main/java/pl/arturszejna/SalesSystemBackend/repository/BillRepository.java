package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.arturszejna.SalesSystemBackend.entity.Bill;

import java.time.LocalDateTime;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("select b from Bill b where b.orderDate >= :dateTime")
    List<Bill> findAllWithDateTimeAfter(
            @Param("dateTime") LocalDateTime creationDateTime);

}
