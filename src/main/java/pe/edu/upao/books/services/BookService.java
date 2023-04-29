package pe.edu.upao.books.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upao.books.models.Book;
import pe.edu.upao.books.repositories.BookRepository;

import java.time.LocalDateTime;

@Service
public class BookService {
    public final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(String title, String author, String description, MultipartFile image) {
        return bookRepository.save(new Book(null, title, author, description, "", LocalDateTime.now(), LocalDateTime.now()));
    }

    public Page<Book> search(String title, String author, String genre, PageRequest page) {
        return bookRepository.search(title, author, genre, page);
    }
}
