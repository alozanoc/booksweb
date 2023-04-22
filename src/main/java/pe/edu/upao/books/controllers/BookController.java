package pe.edu.upao.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upao.books.models.Book;
import pe.edu.upao.books.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestParam String title,
                                        @RequestParam String author,
                                        @RequestParam String description,
                                        @RequestParam MultipartFile image) {
        Book newBook = bookService.addBook(title, author, description, image);
        return ResponseEntity.ok(newBook);
    }
}