package com.empresa.financeiro.controller;


import com.empresa.financeiro.DTO.UsuarioRequestDTO;
import com.empresa.financeiro.DTO.UsuarioResponseDTO;
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

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService,
                             UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(
            @RequestBody @Valid UsuarioRequestDTO dto
    ) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario salvo = usuarioService.criar(usuario);
        return ResponseEntity.ok(usuarioMapper.toResponseDTO(salvo));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(
                usuarios.stream()
                        .map(usuarioMapper::toResponseDTO)
                        .toList()
        );
    }
}
