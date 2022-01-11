package com.hscastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hscastro.entities.ServicoPrestado;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long>{

}
