package com.auth_login.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth_login.application.dto.ListAllUserResponseDTO;
import com.auth_login.application.dto.UserReponseDTO;
import com.auth_login.application.service.UserService;
import com.auth_login.domain.entities.user.User;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<ListAllUserResponseDTO> getAllUsers( @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        ListAllUserResponseDTO users = userService.getAllUser(pageable);
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReponseDTO> getUserById(@PathVariable final Long id) {
        UserReponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable final Long id, @RequestBody final User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/status/{id}/{status}")
    public ResponseEntity updateUser(@PathVariable final Long id, @PathVariable final boolean status) {
        userService.updateStatusById(id, status);
        return ResponseEntity.ok().build();
    }
}
