package com.empresa.financeiro.service;

import com.empresa.financeiro.DTO.LoginRequestDTO;
import com.empresa.financeiro.entity.UserCredential;
import com.empresa.financeiro.entity.Usuario;
import com.empresa.financeiro.exception.BusinessException;
import com.empresa.financeiro.exception.ResourceNotFoundException;
import com.empresa.financeiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}

