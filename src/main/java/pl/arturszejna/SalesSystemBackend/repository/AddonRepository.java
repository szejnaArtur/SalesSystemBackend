package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.Addon;

public interface AddonRepository extends JpaRepository<Addon, Long> {

}
