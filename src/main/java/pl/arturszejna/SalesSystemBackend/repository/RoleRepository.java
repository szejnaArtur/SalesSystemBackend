package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.repository.CrudRepository;
import pl.arturszejna.SalesSystemBackend.entity.Role;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
