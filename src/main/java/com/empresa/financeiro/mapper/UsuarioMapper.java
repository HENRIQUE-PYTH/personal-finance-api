package com.empresa.financeiro.mapper;

import com.empresa.financeiro.DTO.DividaRequestDTO;
import com.empresa.financeiro.DTO.DividaResponseDTO;
import com.empresa.financeiro.DTO.UsuarioRequestDTO;
import com.empresa.financeiro.DTO.UsuarioResponseDTO;
import com.empresa.financeiro.entity.Divida;
import com.empresa.financeiro.entity.Usuario;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario user = new Usuario();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        return user;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario user) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        return dto;
    }

}
