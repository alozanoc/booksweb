package pe.edu.upao.books.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.books.controllers.dto.ReviewDTO;
import pe.edu.upao.books.controllers.dto.ReviewRequest;
import pe.edu.upao.books.models.Review;
import pe.edu.upao.books.services.BookService;

@RestController
@RequestMapping("/api/books/{bookId}/feed")
public class BookFeedController {

    private final BookService bookService;

    public BookFeedController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add-review")
    public ResponseEntity<ReviewDTO> addReview(
            @PathVariable Long bookId,
            @RequestBody ReviewRequest request
            ) {
        Review review = bookService.addReview(null, bookId, request.getComment());
        return ResponseEntity.ok(new ReviewDTO(review));
    }
}
