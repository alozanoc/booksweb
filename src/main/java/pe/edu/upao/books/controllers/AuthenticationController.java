package pe.edu.upao.books.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.books.controllers.dto.LoginRequest;
import pe.edu.upao.books.controllers.dto.SimpleUserDTO;
import pe.edu.upao.books.models.User;
import pe.edu.upao.books.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<SimpleUserDTO> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new SimpleUserDTO(user.getName(), user.getUsername()));
    }

}
