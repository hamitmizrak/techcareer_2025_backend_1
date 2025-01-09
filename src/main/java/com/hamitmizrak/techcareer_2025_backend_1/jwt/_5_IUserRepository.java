package com.hamitmizrak.techcareer_2025_backend_1.jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface _5_IUserRepository extends JpaRepository<_4_UserEntity,Long> {

    // Delivered Query
    // username: Email address
    Optional<_4_UserEntity> findByUsername(String username);
}
