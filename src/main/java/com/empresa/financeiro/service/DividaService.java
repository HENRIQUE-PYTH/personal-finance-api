package com.empresa.financeiro.service;

import com.empresa.financeiro.entity.Divida;
import com.empresa.financeiro.entity.Usuario;
import com.empresa.financeiro.exception.BusinessException;
import com.empresa.financeiro.exception.ResourceNotFoundException;
import com.empresa.financeiro.repository.DividaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DividaService {
    private final DividaRepository repository;
    private final UsuarioService usuarioService;

    public DividaService(DividaRepository repository,
                         UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    public Divida criar(Divida divida, Long usuarioId) {

        if (divida.getValorTotal() == null || divida.getValorTotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("Valor total da dívida deve ser maior que zero");
        }

        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        divida.setUsuario(usuario);

        if (divida.getValorPago() == null) {
            divida.setValorPago(BigDecimal.ZERO);
        }

        if (divida.getDataVencimento() == null) {
            divida.setDataVencimento(LocalDate.now());
        }


        return repository.save(divida);
    }

    public Divida buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dívida não encontrada"));
    }
}
