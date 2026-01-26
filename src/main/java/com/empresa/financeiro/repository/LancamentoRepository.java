package com.empresa.financeiro.repository;

import com.empresa.financeiro.entity.Lancamento;
import com.empresa.financeiro.entity.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento,Long> {

    List<Lancamento> findByUsuario_Id(Long usuarioId);
    List<Lancamento> findByUsuarioIdAndTipo(Long usuarioId, TipoLancamento tipo);
    Optional<Lancamento> findByIdAndUsuarioId(Long lancamentoId, Long usuarioId);
}
