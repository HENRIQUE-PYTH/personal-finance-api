package com.empresa.financeiro.controller;

import com.empresa.financeiro.DTO.DividaRequestDTO;
import com.empresa.financeiro.DTO.DividaResponseDTO;
import com.empresa.financeiro.entity.Divida;
import com.empresa.financeiro.mapper.DividaMapper;
import com.empresa.financeiro.service.DividaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios/{usuarioId}/dividas")
public class DividaController {

    private final DividaService service;
    private final DividaMapper mapper;

    public DividaController(DividaService service, DividaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<DividaResponseDTO> criar(
            @PathVariable Long usuarioId,
            @RequestBody @Valid DividaRequestDTO dto
    ) {
        Divida divida = mapper.toEntity(dto);
        Divida salva = service.criar(divida, usuarioId);
        return ResponseEntity.ok(mapper.toResponseDTO(salva));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DividaResponseDTO> buscarPorId(@PathVariable Long id) {
        Divida divida = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDTO(divida));
    }
}

