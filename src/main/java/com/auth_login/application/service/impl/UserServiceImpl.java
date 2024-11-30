package com.auth_login.application.service.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auth_login.application.dto.PageableDTO;
import com.auth_login.application.dto.user.ListAllUserResponseDTO;
import com.auth_login.application.dto.user.UpdateUserRequestDTO;
import com.auth_login.application.dto.user.UserReponseDTO;
import com.auth_login.application.repository.UserRepository;
import com.auth_login.application.service.UserService;
import com.auth_login.application.service.mapper.UserMapper;
import com.auth_login.domain.entities.user.User;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ListAllUserResponseDTO getAllUser(Pageable pageable) {
        Page<User> users = userRepository
            .findAll(pageable);

         PageableDTO pageableDTO = new PageableDTO(
            users.getTotalPages(),
            users.getNumber(),
            users.getSize()
        );

        var usersMapper = users.getContent().stream()
                    .map(userMapper::toDto)
                    .collect(Collectors.toList());

        return new ListAllUserResponseDTO(usersMapper, pageableDTO);
    }

    @Override
    public UserReponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public void updateUser(Long id, UpdateUserRequestDTO userUpdate) {
       User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setName(userUpdate.name());
        user.setStatus(userUpdate.status());

        userRepository.save(user);
    }

    @Override
    public void updateStatusById(final Long id, final boolean status) {
        var userUpateStatus = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        userUpateStatus.updateStatus(status);
        userRepository.save(userUpateStatus);
    }


}
