package com.empresa.financeiro.DTO;

import com.empresa.financeiro.entity.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class LancamentoRequestDTO {

    private String descricao;
    private BigDecimal valor;
    private TipoLancamento tipo;
    private LocalDate data;

    public LancamentoRequestDTO() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}

