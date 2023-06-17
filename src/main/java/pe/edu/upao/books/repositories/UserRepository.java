package pe.edu.upao.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upao.books.models.Book;
import pe.edu.upao.books.models.User;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
