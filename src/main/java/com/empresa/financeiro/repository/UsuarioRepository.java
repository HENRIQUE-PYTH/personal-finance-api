package com.empresa.financeiro.repository;

import com.empresa.financeiro.entity.Divida;
import com.empresa.financeiro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
