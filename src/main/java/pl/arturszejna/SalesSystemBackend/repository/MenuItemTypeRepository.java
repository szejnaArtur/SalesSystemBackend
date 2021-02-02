package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.MenuItemType;

public interface MenuItemTypeRepository extends JpaRepository<MenuItemType, Long> {

}
