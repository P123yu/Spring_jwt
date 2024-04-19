package com.jwt.repository;

import com.jwt.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);
}
