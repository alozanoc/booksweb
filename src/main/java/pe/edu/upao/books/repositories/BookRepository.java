package pe.edu.upao.books.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upao.books.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    public List<Book> listByTitle(String title);
    @Query("SELECT b FROM Book b WHERE UPPER(b.title) LIKE CONCAT('%', UPPER(:title), '%')" +
            "AND UPPER(b.author) LIKE CONCAT('%', UPPER(:author), '%')" +
            "AND (:genre IS NULL OR UPPER(b.genre) = :genre)")
    Page<Book> search(String title, String author, String genre, PageRequest page);
}
