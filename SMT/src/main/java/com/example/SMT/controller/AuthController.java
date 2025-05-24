package com.example.SMT.controller;

import com.example.SMT.entity.User;
import com.example.SMT.repository.UserRepository;
import com.example.SMT.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")


public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUser) {
        Optional<User> existingUser = userRepository.findByEmail(newUser.getEmail());
        Optional<User> existingNumber = userRepository.findByphoneNumber(newUser.getPhoneNumber());
        Optional<User> existingsociety = userRepository.findBysocietyregno(newUser.getSocietyregno());

        if (existingNumber.isPresent()){
            return ResponseEntity.status(400).body("Phone Number Already Exists");
        }
        if (existingsociety.isPresent()){
            return ResponseEntity.status(400).body("Society Registration Number Already Exists");
        }

        if (existingUser.isPresent()) {
            return ResponseEntity.status(400).body("Email already exists");
        }

        // For demo: storing plain password (in production use hashing)
        userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully");
    }

    // Login existing user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        Optional<User> userOpt = userRepository.findByEmail(loginRequest.getEmail());

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid email");
        }

        User user = userOpt.get();

        // Plain text password check (demo only)
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.ok(new AuthResponse(token));
    }

    // Response class for sending token
    static class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
