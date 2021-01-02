package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.QuantityType;

public interface QuantityTypeRepository extends JpaRepository<QuantityType, Long> {

}
