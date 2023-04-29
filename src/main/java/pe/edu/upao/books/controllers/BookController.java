package pe.edu.upao.books.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping("/search")
    public ResponseEntity<Page<Book>> search(@RequestParam(defaultValue = "", required = false) String title,
                                             @RequestParam(defaultValue = "0", required = false) Integer page,
                                             @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        Page<Book> book = bookService.search(title, PageRequest.of(page, pageSize));
        return ResponseEntity.ok(book);
    }
}