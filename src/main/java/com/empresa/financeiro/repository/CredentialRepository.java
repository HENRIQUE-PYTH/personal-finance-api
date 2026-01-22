package com.empresa.financeiro.repository;

import com.empresa.financeiro.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<UserCredential, Long> {
    boolean existsByEmail(String email);
    Optional<UserCredential> findByEmail(String email);
}
