package com.todocodeacademy.platos.repository;

import com.todocodeacademy.platos.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlatoRepository extends JpaRepository <Plato,Long> {
}
