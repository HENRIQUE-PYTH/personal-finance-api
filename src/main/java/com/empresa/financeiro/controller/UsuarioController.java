package com.empresa.financeiro.controller;


import com.empresa.financeiro.DTO.DividaResponseDTO;
import com.empresa.financeiro.DTO.UsuarioRequestDTO;
import com.empresa.financeiro.DTO.UsuarioResponseDTO;
import com.empresa.financeiro.entity.Divida;
import com.empresa.financeiro.entity.Usuario;
import com.empresa.financeiro.mapper.UsuarioMapper;
import com.empresa.financeiro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    public UsuarioController(UsuarioService service, UsuarioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(
            @RequestBody @Valid UsuarioRequestDTO dto
    ) {
        Usuario usuario = mapper.toEntity(dto);
        Usuario salvo = service.criar(usuario);
        return ResponseEntity.ok(mapper.toResponseDTO(salvo));
    }


    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        List<Usuario> usuarios = service.listarTodos();
        return ResponseEntity.ok(
                usuarios.stream().map(mapper::toResponseDTO).toList()
        );
    }
}
