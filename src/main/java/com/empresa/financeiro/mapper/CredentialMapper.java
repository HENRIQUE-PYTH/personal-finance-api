package com.empresa.financeiro.mapper;

import com.empresa.financeiro.DTO.LoginRequestDTO;
import com.empresa.financeiro.DTO.LoginResponseDTO;
import com.empresa.financeiro.entity.UserCredential;
import com.empresa.financeiro.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class CredentialMapper {

    public UserCredential toEntity(LoginRequestDTO dto, Usuario usuario){
        UserCredential credential = new UserCredential();
        credential.setEmail(dto.getEmail());
        credential.setSenha(dto.getSenha());
        credential.setUsuario(usuario);
        return credential;
    }

    public LoginResponseDTO toResponseDTO(UserCredential credential){
        LoginResponseDTO dto = new LoginResponseDTO();
        dto.setEmail(credential.getEmail());
        return dto;
    }
}
