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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LancamentoRequestDTO that)) return false;
        return Objects.equals(getDescricao(), that.getDescricao()) && Objects.equals(getValor(), that.getValor()) && getTipo() == that.getTipo() && Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescricao(), getValor(), getTipo(), getData());
    }
}

