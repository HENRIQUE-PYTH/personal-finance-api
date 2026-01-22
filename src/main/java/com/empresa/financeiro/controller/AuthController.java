package com.empresa.financeiro.controller;

import com.empresa.financeiro.DTO.LoginRequestDTO;
import com.empresa.financeiro.DTO.LoginResponseDTO;
import com.empresa.financeiro.service.UserCredentialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserCredentialService service;

    public AuthController(UserCredentialService service) {
        this.service = service;
    }

    @PostMapping("/cadastro/{id}")
    public ResponseEntity<LoginResponseDTO> cadastro(
            @RequestBody @Valid LoginRequestDTO dto, @PathVariable Long id) {

        LoginResponseDTO response = service.cadastro(dto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody @Valid LoginRequestDTO dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}
