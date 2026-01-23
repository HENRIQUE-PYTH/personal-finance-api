package com.empresa.financeiro.DTO;

import jakarta.validation.constraints.Email;

public class RegisterResponseDTO {
    private String nome;
    @Email
    private String email;

    public RegisterResponseDTO() {
    }

    public RegisterResponseDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
