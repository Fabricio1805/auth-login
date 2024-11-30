package com.auth_login.application.service;

import org.springframework.data.domain.Pageable;

import com.auth_login.application.dto.user.ListAllUserResponseDTO;
import com.auth_login.application.dto.user.UpdateUserRequestDTO;
import com.auth_login.application.dto.user.UserReponseDTO;

public interface UserService {
    ListAllUserResponseDTO getAllUser(Pageable pageable);
    UserReponseDTO getUserById(final Long id);
    void updateUser(final Long id, final UpdateUserRequestDTO userUpdate);
    void updateStatusById(final Long id, final boolean status);
}
