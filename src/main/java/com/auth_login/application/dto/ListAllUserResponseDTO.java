package com.auth_login.application.dto;

import java.util.List;

public record ListAllUserResponseDTO( List<UserReponseDTO> users,PageableDTO pageable ) {

}
