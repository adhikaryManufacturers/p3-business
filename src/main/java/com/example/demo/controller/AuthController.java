package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.LoginResponse;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String home() {
        return "Backend is running successfully!";
    }

    // LOGIN API
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody User user) {

        Optional<User> existing = repo.findByEmail(user.getEmail());

        if (existing.isPresent() &&
                existing.get().getPassword().equals(user.getPassword())) {

            LoginResponse res = new LoginResponse(
                    true,
                    existing.get().getEmail(),
                    "Login successful"
            );

            return ResponseEntity.ok(res);

        } else {
            LoginResponse res = new LoginResponse(
                    false,
                    null,
                    "Invalid credentials"
            );

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {

        Optional<User> existing = repo.findByEmail(user.getEmail());

        if (existing.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, null, "Email already registered"));
        }

        repo.save(user);

        return ResponseEntity.ok(
                new LoginResponse(true, user.getEmail(), "Registration successful")
        );
    }

    @GetMapping("/users") // ✅ ADD
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(repo.findAll());
    }
}