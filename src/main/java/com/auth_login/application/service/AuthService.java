package com.auth_login.application.service;

import com.auth_login.application.dto.user.AuthResponseDTO;
import com.auth_login.application.dto.user.LoginRequestDTO;
import com.auth_login.application.dto.user.RegisterRequestDTO;
import com.auth_login.application.dto.user.UserReponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);
    UserReponseDTO register(RegisterRequestDTO registerRequestDTO);
}
