package com.jwt.repository;

import com.jwt.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleModel,Long> {

    Optional<RoleModel> findByName(String name);
}
