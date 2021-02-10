package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    MenuItem findByIdMenuItem(Long id);
}
