package my.company.groomer.controllers;

import my.company.groomer.domains.User;
import my.company.groomer.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User fetchedUser = authService.login(user);
        if (fetchedUser != null) {
            return ResponseEntity.ok(fetchedUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (authService.register(user)) {
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
