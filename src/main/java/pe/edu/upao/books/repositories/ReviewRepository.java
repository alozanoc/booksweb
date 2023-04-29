package pe.edu.upao.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upao.books.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
