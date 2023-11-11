package com.todocodeacademy.platos.service;

import com.todocodeacademy.platos.model.Plato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPlatoService {

    public List<Plato> getPlatos();

    public void savePlato(String nombre, Double precio, String descripcion);

    public void deletePlato(Long id);

    public Plato findPlato(Long id);

    public void editPlato (Long id, Plato plato);

    Plato findPlatoDni(String dni);

    //  public Paciente findPacienteByDni(String dni);

}
