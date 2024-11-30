package com.auth_login.application.service;

import org.springframework.data.domain.Pageable;

import com.auth_login.application.dto.ListAllUserResponseDTO;
import com.auth_login.application.dto.UserReponseDTO;
import com.auth_login.domain.entities.user.User;

public interface UserService {
    ListAllUserResponseDTO getAllUser(Pageable pageable);
    UserReponseDTO getUserById(final Long id);
    void updateUser(final Long id, final User user);
    void updateStatusById(final Long id, final boolean status);
}
