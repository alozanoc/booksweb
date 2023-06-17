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

    public User authenticate(String username, String password) {
        Optional<User> result = this.userRepository.findByUsername(username);
        if (result.isEmpty()) {
            return null;
        }

        if (Objects.equals(result.get().getPassword(), password)) {
            return result.get();
        }
        return null;
    }
}
