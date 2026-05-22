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
        return "P3 Business backend is running!";
    }

    // ── LOGIN — same endpoint for both admin and customer ──────────────────
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody User user) {

        Optional<User> existing = repo.findByEmail(user.getEmail());

        if (existing.isPresent() &&
                existing.get().getPassword().equals(user.getPassword())) {

            User u = existing.get();
            LoginResponse res = new LoginResponse(
                    true,
                    u.getId(),
                    u.getName(),
                    u.getEmail(),
                    u.getPhone(),
                    u.getRole(),
                    u.getAddress(),
                    "Login successful"
            );
            return ResponseEntity.ok(res);

        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(false, null, "Invalid email or password"));
        }
    }

    // ── SIGNUP ──────────────────────────────────────────────────────────────
    // source header: "website" → CUSTOMER role
    //                "suite"   → ADMIN role (or any other value)
    @PostMapping("/signup")
    public ResponseEntity<LoginResponse> signup(
            @RequestBody User user,
            @RequestHeader(value = "X-Source", defaultValue = "website") String source) {

        // Check duplicate email
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, null, "Email already registered"));
        }

        // ── Role assignment based on source ──────────────────────────────
        // website → always CUSTOMER
        // suite   → ADMIN
        if ("suite".equalsIgnoreCase(source)) {
            user.setRole("ADMIN");
        } else {
            user.setRole("CUSTOMER");
        }

        // Never allow role override from request body for security
        User saved = repo.save(user);

        LoginResponse res = new LoginResponse(
                true,
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getRole(),
                saved.getAddress(),
                "Registration successful"
        );
        return ResponseEntity.ok(res);
    }

    // ── GET ALL USERS (admin use) ───────────────────────────────────────────
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(repo.findAll());
    }
}