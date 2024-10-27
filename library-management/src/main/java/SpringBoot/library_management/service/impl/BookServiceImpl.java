package SpringBoot.library_management.service.impl;
import SpringBoot.library_management.exception.ResourceNotFoundException;

import SpringBoot.library_management.dto.BookDTO;
import SpringBoot.library_management.model.Book;
import SpringBoot.library_management.repository.BookRepository;
import SpringBoot.library_management.repository.CategoryRepository;
import SpringBoot.library_management.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        return convertToDTO(book);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));

        BeanUtils.copyProperties(bookDTO, existingBook, "id", "category");
        if (bookDTO.getCategoryId() != null) {
            existingBook.setCategory(categoryRepository.findById(bookDTO.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category", "id", bookDTO.getCategoryId())));
        }

        Book updatedBook = bookRepository.save(existingBook);
        return convertToDTO(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book", "id", id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> findBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksByCategory(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO);
        if (book.getCategory() != null) {
            bookDTO.setCategoryId(book.getCategory().getId());
        }
        return bookDTO;
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book, "id", "category");
        if (bookDTO.getCategoryId() != null) {
            book.setCategory(categoryRepository.findById(bookDTO.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category", "id", bookDTO.getCategoryId())));
        }
        return book;
    }
}
