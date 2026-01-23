package com.empresa.financeiro.service;

import com.empresa.financeiro.DTO.LoginRequestDTO;
import com.empresa.financeiro.DTO.LoginResponseDTO;
import com.empresa.financeiro.DTO.RegisterRequestDTO;
import com.empresa.financeiro.DTO.RegisterResponseDTO;
import com.empresa.financeiro.entity.UserCredential;
import com.empresa.financeiro.entity.Usuario;
import com.empresa.financeiro.exception.BusinessException;
import com.empresa.financeiro.exception.UsuarioNotFoundException;
import com.empresa.financeiro.repository.CredentialRepository;
import com.empresa.financeiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {

    private final UsuarioRepository usuarioRepository;
    private final CredentialRepository credentialRepository;

    public UserCredentialService(UsuarioRepository usuarioRepository,
                                 CredentialRepository credentialRepository) {
        this.usuarioRepository = usuarioRepository;
        this.credentialRepository = credentialRepository;
    }

    /* ======================= CADASTRO ======================= */

    public RegisterResponseDTO register(RegisterRequestDTO dto) {

        // 1 Verifica se o email já existe
        if (credentialRepository.existsByEmail(dto.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }

        // 2 Cria o usuário
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());

        // 3 Cria a credencial
        UserCredential credential = new UserCredential();
        credential.setEmail(dto.getEmail());
        credential.setSenha(dto.getSenha()); // depois entra encoder
        credential.setUsuario(usuario);

        // 4 Relaciona os dois lados
        usuario.setCredential(credential);


        // 5 Salva (usuario primeiro ou cascade)
        usuarioRepository.save(usuario);

        // 6 Retorno
        return new RegisterResponseDTO(
                usuario.getNome(),
                credential.getEmail()
        );
    }

    /* ======================= LOGIN ======================= */

    public LoginResponseDTO login(LoginRequestDTO dto) {

        // 1 Busca credencial pelo email
        UserCredential credential = credentialRepository
                .findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new BusinessException("Email ou senha inválidos")
                );

        // 2️Valida senha
        if (!credential.getSenha().equals(dto.getSenha())) {
            throw new BusinessException("Email ou senha inválidos");
        }

        Usuario usuario = credential.getUsuario();

        // 3 Retorno
        return new LoginResponseDTO(
                usuario.getNome(),
                credential.getEmail()
        );
    }
}
