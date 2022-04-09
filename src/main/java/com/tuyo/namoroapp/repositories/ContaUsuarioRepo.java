package com.tuyo.namoroapp.repositories;

import com.tuyo.namoroapp.entities.ContaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContaUsuarioRepo extends JpaRepository<ContaUsuario, Integer> {

    @Query("from ContaUsuario where idade=:idade ,cidade=:cidade and estado=:estado and id!=id")                                                 // Query trabalha com Entidades e não com tabelas do Database.
    List<ContaUsuario> findMatches();                                           //Por isso é utilizado a entidade ContaUsuario diretamente.


}
