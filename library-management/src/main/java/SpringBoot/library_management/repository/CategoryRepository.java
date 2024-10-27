// CategoryRepository.java
package SpringBoot.library_management.repository;

import SpringBoot.library_management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContainingIgnoreCase(String name);
    boolean existsByName(String name);
}