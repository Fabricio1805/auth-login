package com.auth_login.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_login.application.dto.AuthResponseDTO;
import com.auth_login.application.dto.LoginRequestDTO;
import com.auth_login.application.dto.RegisterRequestDTO;
import com.auth_login.application.dto.UserReponseDTO;
import com.auth_login.application.service.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        AuthResponseDTO authResponseDTO = authService.login(loginRequestDTO);

        return ResponseEntity.ok(authResponseDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<UserReponseDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        UserReponseDTO userReponseDTO = authService.register(registerRequestDTO);
        return ResponseEntity.ok(userReponseDTO);
    }
}
