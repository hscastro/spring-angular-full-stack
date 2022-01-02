package com.hscastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hscastro.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
