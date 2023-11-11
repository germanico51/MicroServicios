package com.todocodeacademy.ingredientes.service;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import com.todocodeacademy.ingredientes.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IIngredienteService {
    List<Ingrediente> getIngredientes();

    void saveIngrediente(Ingrediente ing);

    void deleteIngrediente(Long id);

    Ingrediente findIngrediente(Long id);

    void editIngrediente(Long id, Ingrediente ing);
    List<Ingrediente> findByPlato(String plato);

    //  public Paciente findPacienteByDni(String dni);

}
