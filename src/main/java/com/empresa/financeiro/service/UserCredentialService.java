package com.empresa.financeiro.service;

import com.empresa.financeiro.DTO.LoginRequestDTO;
import com.empresa.financeiro.DTO.LoginResponseDTO;
import com.empresa.financeiro.entity.UserCredential;
import com.empresa.financeiro.entity.Usuario;
import com.empresa.financeiro.exception.BusinessException;
import com.empresa.financeiro.exception.UsuarioNotFoundException;
import com.empresa.financeiro.repository.CredentialRepository;
import com.empresa.financeiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {

    private final CredentialRepository credentialRepository;
    private final UsuarioRepository usuarioRepository;

    public UserCredentialService(CredentialRepository credentialRepository,
                                 UsuarioRepository usuarioRepository) {
        this.credentialRepository = credentialRepository;
        this.usuarioRepository = usuarioRepository;
    }

    /* ================= CADASTRO ================= */

    public LoginResponseDTO cadastro(LoginRequestDTO dto, Long id) {

        if (credentialRepository.existsByEmail(dto.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado"));

        UserCredential credential = new UserCredential();
        credential.setEmail(dto.getEmail());
        credential.setSenha(dto.getSenha());
        credential.setUsuario(usuario);

        credentialRepository.save(credential);

        return new LoginResponseDTO(
                credential.getEmail()
        );
    }

    /* ================= LOGIN ================= */

    public LoginResponseDTO login(LoginRequestDTO dto) {

        UserCredential credential = credentialRepository
                .findByEmail(dto.getEmail())
                .orElseThrow(() -> new BusinessException("Email ou senha inválidas"));

        if (!credential.getSenha().equals(dto.getSenha())) {
            throw new BusinessException("Email ou senha inválidas");
        }

        return new LoginResponseDTO(
                credential.getEmail()
        );
    }
}
