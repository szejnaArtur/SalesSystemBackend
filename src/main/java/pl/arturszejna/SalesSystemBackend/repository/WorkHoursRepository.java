package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.WorkHours;

public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {

}
