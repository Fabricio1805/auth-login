package com.auth_login.application.dto.user;

import java.util.List;

import com.auth_login.application.dto.PageableDTO;

public record ListAllUserResponseDTO( List<UserReponseDTO> users,PageableDTO pageable ) {

}
