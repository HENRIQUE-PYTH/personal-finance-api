package com.empresa.financeiro.repository;

import com.empresa.financeiro.entity.Lancamento;
import com.empresa.financeiro.entity.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento,Long> {

    List<Lancamento> findByUsuario_Id(Long usuarioId);
    List<Lancamento> findByUsuarioIdAndTipo(Long usuarioId, TipoLancamento tipo);
}
