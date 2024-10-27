// BookService.java
package SpringBoot.library_management.service;

import SpringBoot.library_management.dto.BookDTO;
import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
    List<BookDTO> findBooksByTitle(String title);
    List<BookDTO> findBooksByCategory(Long categoryId);
}

