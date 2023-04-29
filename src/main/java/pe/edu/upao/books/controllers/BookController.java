package pe.edu.upao.books.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upao.books.controllers.dto.BookDTO;
import pe.edu.upao.books.controllers.dto.BookSmallDTO;
import pe.edu.upao.books.controllers.dto.PageDTO;
import pe.edu.upao.books.models.Book;
import pe.edu.upao.books.services.BookService;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestParam String title,
                                           @RequestParam String author,
                                           @RequestParam String description,
                                           @RequestParam MultipartFile image) {
        Book newBook = bookService.addBook(title, author, description, image);
        return ResponseEntity.ok(new BookDTO(newBook));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> get(@PathVariable Long bookId) {
        Optional<Book> newBook = bookService.findById(bookId);
        if(!newBook.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new BookDTO(newBook.get()));
    }


    @GetMapping("/search")
    public ResponseEntity<PageDTO<BookSmallDTO>> search(@RequestParam(defaultValue = "", required = false) String title,
                                                        @RequestParam(defaultValue = "", required = false) String author,
                                                        @RequestParam(required = false) String genre,
                                                        @RequestParam(defaultValue = "0", required = false) Integer page,
                                                        @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        Page<Book> books = bookService.search(title, author, genre, PageRequest.of(page, pageSize));
        return ResponseEntity.ok(
                new PageDTO<>(
                        books.map(it -> new BookSmallDTO(it)).stream().toList(),
                        books.getNumber(),
                        books.getTotalElements())
        );
    }
}