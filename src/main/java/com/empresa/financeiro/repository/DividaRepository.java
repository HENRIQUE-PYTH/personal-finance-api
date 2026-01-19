package com.empresa.financeiro.repository;

import com.empresa.financeiro.entity.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Long> {

}
