// BookRepository.java
package SpringBoot.library_management.repository;

import SpringBoot.library_management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByCategoryId(Long categoryId);
    boolean existsByIsbn(String isbn);
}

