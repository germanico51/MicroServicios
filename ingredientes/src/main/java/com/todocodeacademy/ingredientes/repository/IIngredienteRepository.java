package com.todocodeacademy.ingredientes.repository;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIngredienteRepository extends JpaRepository<Ingrediente,Long> {

    @Query("SELECT i from Ingrediente i WHERE :plato MEMBER OF i.platos")
    List<Ingrediente> findByNombre(String plato);
}
