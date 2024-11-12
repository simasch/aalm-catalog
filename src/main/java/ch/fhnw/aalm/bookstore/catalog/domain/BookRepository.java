package ch.fhnw.aalm.bookstore.catalog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String description, String author);
}
