package com.auth_login.application.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_login.application.repository.UserRepository;
import com.auth_login.domain.dto.AuthResponseDTO;
import com.auth_login.domain.dto.LoginRequestDTO;
import com.auth_login.domain.dto.RegisterRequestDTO;
import com.auth_login.domain.entities.user.User;
import com.auth_login.infra.security.TokenService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new RuntimeException("User Not Found"));

        if(passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new AuthResponseDTO(user.getName(), token));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        Optional<User> user = userRepository.findByEmail(registerRequestDTO.email());

        if(user.isEmpty()) {
            User newUser = new User();

            newUser.setPassword(passwordEncoder.encode(registerRequestDTO.password()));
            newUser.setName(registerRequestDTO.name());
            newUser.setEmail(registerRequestDTO.email());

            this.userRepository.save(newUser);
            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new AuthResponseDTO(newUser.getName(), token));
        }

        return ResponseEntity.badRequest().build();
    }
}
