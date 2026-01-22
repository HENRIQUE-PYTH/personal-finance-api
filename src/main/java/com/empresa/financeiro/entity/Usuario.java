package com.empresa.financeiro.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "usuario")
    private List<Lancamento> lancamentos;

    @OneToMany(mappedBy = "usuario")
    private List<Divida> dividas;

    @OneToOne(mappedBy = "usuario")
    private UserCredential credential;

    public Usuario() {
    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UserCredential getCredential() {
        return credential;
    }

    public void setCredential(UserCredential credential) {
        this.credential = credential;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    public List<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getLancamentos(), usuario.getLancamentos()) && Objects.equals(getDividas(), usuario.getDividas()) && Objects.equals(getCredential(), usuario.getCredential());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getLancamentos(), getDividas(), getCredential());
    }
}
