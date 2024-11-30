package com.auth_login.application.service;

import com.auth_login.application.dto.AuthResponseDTO;
import com.auth_login.application.dto.LoginRequestDTO;
import com.auth_login.application.dto.RegisterRequestDTO;
import com.auth_login.application.dto.UserReponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);
    UserReponseDTO register(RegisterRequestDTO registerRequestDTO);
}
