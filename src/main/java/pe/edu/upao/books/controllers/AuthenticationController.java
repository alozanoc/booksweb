package pe.edu.upao.books.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.books.controllers.dto.LoginRequest;
import pe.edu.upao.books.controllers.dto.SimpleUserDTO;
import pe.edu.upao.books.models.User;
import pe.edu.upao.books.services.UserService;
import pe.edu.upao.books.util.EncryptionUtil;
import pe.edu.upao.books.util.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {


    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    public AuthenticationController(UserDetailsService userService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserService userService1) {
        this.userDetailsService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService1;
    }

    @PostMapping("/login")
    public ResponseEntity<SimpleUserDTO> login(@RequestBody LoginRequest loginRequest) throws Exception {
        authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);


        final User user = userService.findByUserName(loginRequest.getUsername());

        return ResponseEntity.ok(new SimpleUserDTO(user.getName(), userDetails.getUsername(), EncryptionUtil.encrypt(token)));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}
