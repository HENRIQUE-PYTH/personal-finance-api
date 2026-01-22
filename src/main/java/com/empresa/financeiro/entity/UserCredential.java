package com.empresa.financeiro.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "credenciais")
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String email;

    @Column(nullable = false, unique = false)
    private String senha;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    public UserCredential() {
    }

    public Long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserCredential that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getSenha(), that.getSenha()) && Objects.equals(getUsuario(), that.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getSenha(), getUsuario());
    }
}
