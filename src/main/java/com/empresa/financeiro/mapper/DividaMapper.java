package com.empresa.financeiro.mapper;

import com.empresa.financeiro.DTO.DividaRequestDTO;
import com.empresa.financeiro.DTO.DividaResponseDTO;
import com.empresa.financeiro.DTO.LancamentoRequestDTO;
import com.empresa.financeiro.DTO.LancamentoResponseDTO;
import com.empresa.financeiro.entity.Divida;
import com.empresa.financeiro.entity.Lancamento;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DividaMapper {

    public Divida toEntity(DividaRequestDTO dto) {
        Divida divida = new Divida();
        divida.setDescricao(dto.getDescricao());
        divida.setValorTotal(dto.getValorTotal());
        divida.setValorPago(dto.getValorPago());
        divida.setDataVencimento(dto.getDataVencimento());
        return divida;
    }

    public DividaResponseDTO toResponseDTO(Divida divida) {
        DividaResponseDTO dto = new DividaResponseDTO();
        dto.setDescricao(divida.getDescricao());
        dto.setValorTotal(divida.getValorTotal());
        dto.setValorPago(divida.getValorPago());
        dto.setDataVencimento(divida.getDataVencimento());
        return dto;
    }
}
