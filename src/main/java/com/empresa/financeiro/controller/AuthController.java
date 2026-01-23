package com.empresa.financeiro.controller;

import com.empresa.financeiro.DTO.LoginRequestDTO;
import com.empresa.financeiro.DTO.LoginResponseDTO;
import com.empresa.financeiro.DTO.RegisterRequestDTO;
import com.empresa.financeiro.DTO.RegisterResponseDTO;
import com.empresa.financeiro.service.UserCredentialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserCredentialService service;

    public AuthController(UserCredentialService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(
            @RequestBody @Valid RegisterRequestDTO dto) {



        RegisterResponseDTO response = service.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody @Valid LoginRequestDTO dto) {

        LoginResponseDTO response = service.login(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
