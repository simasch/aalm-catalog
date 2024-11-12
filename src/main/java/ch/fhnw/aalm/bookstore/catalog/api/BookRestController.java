package ch.fhnw.aalm.bookstore.catalog.api;

import ch.fhnw.aalm.bookstore.catalog.domain.Book;
import ch.fhnw.aalm.bookstore.catalog.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("books")
    List<Book> get(String keywords) {
        String search = keywords == null ? "" : keywords;
        return bookRepository.findAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                search, search, search);
    }
}
