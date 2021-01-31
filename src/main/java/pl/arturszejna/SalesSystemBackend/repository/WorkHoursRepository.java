package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.Employee;
import pl.arturszejna.SalesSystemBackend.entity.WorkHours;

import java.util.List;

public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {

    List<WorkHours> findAllByEmployee(Employee employee);

    List<WorkHours> findAllByEndWorkIsNull();

}
