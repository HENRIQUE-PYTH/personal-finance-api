package com.empresa.financeiro.mapper;

import com.empresa.financeiro.DTO.LancamentoRequestDTO;
import com.empresa.financeiro.DTO.LancamentoResponseDTO;
import com.empresa.financeiro.entity.Lancamento;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LancamentoMapper {

    public Lancamento toEntity(LancamentoRequestDTO dto) {
        Lancamento lancamento = new Lancamento();
        lancamento.setDescricao(dto.getDescricao());
        lancamento.setValor(dto.getValor());
        lancamento.setTipo(dto.getTipo());
        lancamento.setData(dto.getData());
        return lancamento;
    }

    public LancamentoResponseDTO toResponseDTO(Lancamento lancamento) {
        LancamentoResponseDTO dto = new LancamentoResponseDTO();
        dto.setDescricao(lancamento.getDescricao());
        dto.setValor(lancamento.getValor());
        dto.setTipo(lancamento.getTipo());
        dto.setData(lancamento.getData());
        return dto;
    }
}

