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

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody @Valid LoginRequestDTO dto) {

        LoginResponseDTO response = service.login(dto);

        Map<String, Object> debug = new HashMap<>();
        debug.put("id", response.getId());
        debug.put("nome", response.getNome());
        debug.put("email", response.getEmail());

        return ResponseEntity.ok(debug);
    }


//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDTO> login(
//            @RequestBody @Valid LoginRequestDTO dto) {
//
//        LoginResponseDTO response = service.login(dto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
}
