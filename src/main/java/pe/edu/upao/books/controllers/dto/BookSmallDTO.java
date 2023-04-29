package pe.edu.upao.books.controllers.dto;

import pe.edu.upao.books.models.Book;
import pe.edu.upao.books.models.Review;

import java.time.LocalDateTime;
import java.util.List;

public class BookSmallDTO {
    private Long id;
    private String title;
    private String author;
    private String description;
    private String imageUrl;


    public BookSmallDTO() {
    }

    public BookSmallDTO(Book book) {
        this.setId(book.getId());
        this.setTitle(book.getTitle());
        this.setAuthor(book.getAuthor());
        this.setDescription(book.getDescription());
        this.setImageUrl(book.getImageUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
