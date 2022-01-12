package com.hscastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.hscastro.entities.ServicoPrestado;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long>{

    @Query("select s from ServicePrestado s join s.cliente c where upper( c.nome ) like upper( :nome ) and  MONTH( s.data ) =:mes ")
    List<ServicoPrestado> findByNameClienteAndMes(@Param("nome") String nome,
        @Param("mes") Integer mes);

}
