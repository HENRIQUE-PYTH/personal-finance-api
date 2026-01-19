package com.empresa.financeiro.service;

import com.empresa.financeiro.entity.Lancamento;
import com.empresa.financeiro.entity.TipoLancamento;
import com.empresa.financeiro.entity.Usuario;
import com.empresa.financeiro.exception.BusinessException;
import com.empresa.financeiro.repository.LancamentoRepository;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class LancamentoService {

    private final LancamentoRepository repository;
    private final UsuarioService usuarioService;

    public LancamentoService(LancamentoRepository repository,
                             UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    public Lancamento registrar(Lancamento lancamento, Long usuarioId) {

        if (lancamento.getValor() == null || lancamento.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("Valor do lançamento deve ser maior que zero");
        }

        if (lancamento.getTipo() == null) {
            throw new BusinessException("Tipo do lançamento é obrigatório");
        }

        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        lancamento.setUsuario(usuario);

        if (lancamento.getData() == null) {
            lancamento.setData(LocalDate.now());
        }

        return repository.save(lancamento);
    }

    public List<Lancamento> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuario_Id(usuarioId);
    }

    public BigDecimal calcularTotalEntradas(Long usuarioId) {
        return repository.findByUsuarioIdAndTipo(usuarioId, TipoLancamento.ENTRADA)
                .stream()
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularTotalSaidas(Long usuarioId) {
        return repository.findByUsuarioIdAndTipo(usuarioId, TipoLancamento.SAIDA)
                .stream()
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularSaldo(Long usuarioId) {
        return calcularTotalEntradas(usuarioId)
                .subtract(calcularTotalSaidas(usuarioId));
    }

}
