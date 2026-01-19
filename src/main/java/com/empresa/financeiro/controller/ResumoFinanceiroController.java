package com.empresa.financeiro.controller;


import com.empresa.financeiro.service.LancamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios/{usuarioId}/resumo")
public class ResumoFinanceiroController {

    private final LancamentoService lancamentoService;

    public ResumoFinanceiroController(LancamentoService lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    @GetMapping
    public ResponseEntity<Map<String, BigDecimal>> resumo(@PathVariable Long usuarioId) {

        BigDecimal entradas = lancamentoService.calcularTotalEntradas(usuarioId);
        BigDecimal saidas = lancamentoService.calcularTotalSaidas(usuarioId);
        BigDecimal saldo = lancamentoService.calcularSaldo(usuarioId);

        Map<String, BigDecimal> resumo = new HashMap<>();
        resumo.put("entradas", entradas);
        resumo.put("saidas", saidas);
        resumo.put("saldo", saldo);

        return ResponseEntity.ok(resumo);
    }
}
