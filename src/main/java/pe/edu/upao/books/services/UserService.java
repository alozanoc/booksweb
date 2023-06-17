package pe.edu.upao.books.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upao.books.models.User;
import pe.edu.upao.books.repositories.UserRepository;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserName(String username) {
        Optional<User> result = this.userRepository.findByUsername(username);
        return result.orElse(null);
    }
}
