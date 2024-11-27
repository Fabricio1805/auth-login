package com.auth_login.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth_login.domain.entities.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
   Optional<User> findByEmail(String email);
}
