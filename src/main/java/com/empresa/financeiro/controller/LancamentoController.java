package com.empresa.financeiro.controller;

import com.empresa.financeiro.DTO.LancamentoRequestDTO;
import com.empresa.financeiro.DTO.LancamentoResponseDTO;
import com.empresa.financeiro.entity.Lancamento;
import com.empresa.financeiro.mapper.LancamentoMapper;
import com.empresa.financeiro.service.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios/{usuarioId}/lancamentos")
public class LancamentoController {



        private final LancamentoService service;
        private final LancamentoMapper mapper;

        public LancamentoController(LancamentoService service, LancamentoMapper mapper) {
            this.service = service;
            this.mapper = mapper;
        }

        @PostMapping
        public ResponseEntity<LancamentoResponseDTO> criar(
                @PathVariable Long usuarioId,
                @RequestBody @Valid LancamentoRequestDTO dto
        ) {
            Lancamento lancamento = mapper.toEntity(dto);
            Lancamento salvo = service.registrar(lancamento, usuarioId);
            return ResponseEntity.ok(mapper.toResponseDTO(salvo));
        }

        @GetMapping
        public ResponseEntity<List<LancamentoResponseDTO>> listarPorUsuario(
                @PathVariable Long usuarioId
        ) {
            List<Lancamento> lancamentos = service.listarPorUsuario(usuarioId);
            return ResponseEntity.ok(
                    lancamentos.stream().map(mapper::toResponseDTO).toList()
            );
        }
    }

