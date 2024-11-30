package com.auth_login.application.dto.user;

import java.util.List;

public record ListAllUserResponseDTO( List<UserReponseDTO> users,PageableDTO pageable ) {

}
