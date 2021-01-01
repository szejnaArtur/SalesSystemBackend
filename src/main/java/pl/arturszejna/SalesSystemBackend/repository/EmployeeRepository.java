package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
