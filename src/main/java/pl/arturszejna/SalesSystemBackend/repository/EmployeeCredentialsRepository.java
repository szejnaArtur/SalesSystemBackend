package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.EmployeeCredentials;

import java.util.Optional;

public interface EmployeeCredentialsRepository extends JpaRepository<EmployeeCredentials, Long> {

    Optional<EmployeeCredentials> findByLogin(String login);

}
