package pe.edu.upao.books.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upao.books.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.title = :title")
    public List<Book> listByTitle(String title);
    @Query("select b from Book b where b.title LIKE CONCAT('%', :title, '%')")
    Page<Book> search(String title, PageRequest page);
}
