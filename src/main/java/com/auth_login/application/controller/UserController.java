package com.auth_login.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok().body("Sucesso!!");
    }

}
