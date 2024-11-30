package com.auth_login.application.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.auth_login.application.dto.user.UserReponseDTO;
import com.auth_login.domain.entities.user.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserReponseDTO dto);
    UserReponseDTO toDto(User user);
}
