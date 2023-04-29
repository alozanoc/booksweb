package pe.edu.upao.books.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upao.books.models.Book;
import pe.edu.upao.books.models.Review;
import pe.edu.upao.books.models.User;
import pe.edu.upao.books.repositories.BookRepository;
import pe.edu.upao.books.repositories.ReviewRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookService {
    public final BookRepository bookRepository;
    public final ReviewRepository reviewRepository;

    public BookService(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }

    public Book addBook(String title, String author, String description, MultipartFile image) {
        return bookRepository.save(new Book(null, title, author, description, "", LocalDateTime.now(), LocalDateTime.now()));
    }

    public Page<Book> search(String title, String author, String genre, PageRequest page) {
        return bookRepository.search(title, author, genre, page);
    }

    public Review addReview(User user, Long bookId, String comment) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Review review = new Review(null, comment, user, book);
        reviewRepository.save(review);
        return review;
    }

    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }
}
