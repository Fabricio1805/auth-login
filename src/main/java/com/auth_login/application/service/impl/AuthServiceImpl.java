package com.auth_login.application.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth_login.application.dto.AuthResponseDTO;
import com.auth_login.application.dto.LoginRequestDTO;
import com.auth_login.application.dto.RegisterRequestDTO;
import com.auth_login.application.dto.UserReponseDTO;
import com.auth_login.application.repository.UserRepository;
import com.auth_login.application.service.AuthService;
import com.auth_login.application.service.mapper.UserMapper;
import com.auth_login.domain.entities.user.User;
import com.auth_login.infra.security.TokenService;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService,
            UserMapper usermapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.usermapper = usermapper;
    }

    private final UserMapper usermapper;

    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new RuntimeException("User Not Found"));

        if(!passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())) {
            throw new RuntimeException("alguma coisa");
        }

        String token = this.tokenService.generateToken(user);

        return new AuthResponseDTO(user.getName(), token);
    }

    @Override
    public UserReponseDTO register(RegisterRequestDTO registerRequestDTO) {
        Optional<User> user = userRepository.findByEmail(registerRequestDTO.email());

        if(!user.isEmpty()) {
            throw new RuntimeException("alguma coisa");
        }

        User newUser = new User();

        newUser.setPassword(passwordEncoder.encode(registerRequestDTO.password()));
        newUser.setName(registerRequestDTO.name());
        newUser.setEmail(registerRequestDTO.email());

        this.userRepository.save(newUser);

        return usermapper.toDto(newUser);
    }

}
