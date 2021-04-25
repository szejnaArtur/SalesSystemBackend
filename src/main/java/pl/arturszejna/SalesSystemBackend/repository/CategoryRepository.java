package pl.arturszejna.SalesSystemBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturszejna.SalesSystemBackend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
