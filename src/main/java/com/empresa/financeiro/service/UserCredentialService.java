package com.empresa.financeiro.service;

import com.empresa.financeiro.DTO.LoginRequestDTO;
import com.empresa.financeiro.DTO.LoginResponseDTO;
import com.empresa.financeiro.DTO.RegisterRequestDTO;
import com.empresa.financeiro.DTO.RegisterResponseDTO;
import com.empresa.financeiro.entity.UserCredential;
import com.empresa.financeiro.entity.Usuario;
import com.empresa.financeiro.exception.BusinessException;
import com.empresa.financeiro.repository.CredentialRepository;
import com.empresa.financeiro.repository.UsuarioRepository;
import com.empresa.financeiro.service.SecurityConfig.SecurityConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {

    private final UsuarioRepository usuarioRepository;
    private final CredentialRepository credentialRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserCredentialService(UsuarioRepository usuarioRepository,
                                 CredentialRepository credentialRepository,
                                 BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.credentialRepository = credentialRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /* ======================= CADASTRO ======================= */

    public RegisterResponseDTO register(RegisterRequestDTO dto) {

        if (credentialRepository.existsByEmail(dto.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());

        UserCredential credential = new UserCredential();
        credential.setEmail(dto.getEmail());
        credential.setSenha(passwordEncoder.encode(dto.getSenha()));
        credential.setUsuario(usuario);

        usuario.setCredential(credential);

        usuarioRepository.save(usuario);

        return new RegisterResponseDTO(
                usuario.getNome(),
                credential.getEmail()
        );
    }

    /* ======================= LOGIN ======================= */

    public LoginResponseDTO login(LoginRequestDTO dto) {

        UserCredential credential = credentialRepository
                .findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new BusinessException("Email ou senha inválidos")
                );

        if (!passwordEncoder.matches(dto.getSenha(), credential.getSenha())) {
            throw new BusinessException("Email ou senha inválidos");
        }

        Usuario usuario = credential.getUsuario();

        return new LoginResponseDTO(
                usuario.getNome(),
                credential.getEmail()
        );
    }
}
