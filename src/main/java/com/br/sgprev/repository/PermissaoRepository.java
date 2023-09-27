package com.br.sgprev.repository;

import java.util.List;

import com.br.sgprev.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

    List<Permissao> findByNome(String nome);
}
