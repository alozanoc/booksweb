package pe.edu.upao.books.controllers.dto;

import pe.edu.upao.books.models.Review;

import java.time.LocalDateTime;

public class ReviewDTO {
    private Long id;
    private String review;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        this.setId(review.getId());
        this.setReview(review.getReview());
        this.setCreatedAt(review.getCreatedAt());
        this.setUpdatedAt(review.getUpdatedAt());
        if(review.getUser() != null) {
            this.setUserId(review.getUser().getId());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
