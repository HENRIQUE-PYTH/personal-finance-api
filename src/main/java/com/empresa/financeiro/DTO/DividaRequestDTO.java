package com.empresa.financeiro.DTO;

import com.empresa.financeiro.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateDeserializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class DividaRequestDTO {

    private String descricao;
    private BigDecimal valorTotal;
    private BigDecimal valorPago;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;

    public DividaRequestDTO() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DividaRequestDTO that)) return false;
        return Objects.equals(getDescricao(), that.getDescricao()) && Objects.equals(getValorTotal(), that.getValorTotal()) && Objects.equals(getValorPago(), that.getValorPago()) && Objects.equals(getDataVencimento(), that.getDataVencimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescricao(), getValorTotal(), getValorPago(), getDataVencimento());
    }
}
