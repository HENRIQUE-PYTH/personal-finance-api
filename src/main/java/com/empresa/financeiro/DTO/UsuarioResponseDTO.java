package com.empresa.financeiro.DTO;

import java.util.Objects;

public class UsuarioResponseDTO {

    private String nome;
    private String email;

    public UsuarioResponseDTO() {
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UsuarioResponseDTO that)) return false;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getEmail());
    }
}
