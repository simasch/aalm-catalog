package ch.fhnw.aalm.bookstore.catalog.api;

import ch.fhnw.aalm.bookstore.catalog.domain.Book;
import ch.fhnw.aalm.bookstore.catalog.domain.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("api/books")
    List<Book> find(String keywords) {
        String search = keywords == null ? "" : keywords;
        return bookRepository.findAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                search, search, search);
    }

    @GetMapping("api/books/{isbn}")
    ResponseEntity<Book> get(@PathVariable String isbn) {
        return bookRepository.findById(isbn)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
