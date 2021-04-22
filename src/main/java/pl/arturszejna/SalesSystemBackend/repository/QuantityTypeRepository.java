package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.Unit;

public interface QuantityTypeRepository extends JpaRepository<Unit, Long> {

}
