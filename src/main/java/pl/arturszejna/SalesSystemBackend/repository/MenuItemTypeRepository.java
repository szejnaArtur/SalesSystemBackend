package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.MenuItemType;

import java.util.Optional;

public interface MenuItemTypeRepository extends JpaRepository<MenuItemType, Long> {

    Optional<MenuItemType> findByName(String name);
}
