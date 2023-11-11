package com.todocodeacademy.ingredientes.service;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import com.todocodeacademy.ingredientes.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService implements IIngredienteService{

    @Autowired
    IIngredienteRepository ingRepo;
    @Override
    public List<Ingrediente> getIngredientes() {
        return ingRepo.findAll();
    }

    @Override
    public void saveIngrediente(Ingrediente ing) {
        ingRepo.save(ing);
    }

    @Override
    public void deleteIngrediente(Long id) {
        ingRepo.deleteById(id);
    }

    @Override
    public Ingrediente findIngrediente(Long id) {
        return ingRepo.findById(id).orElse(null);
    }

    @Override
    public void editIngrediente(Long id, Ingrediente ing) {
        this.saveIngrediente(ing);
    }

    @Override
    public List<Ingrediente> findByPlato(String nombrePlato) {
        List<Ingrediente> listaIngredientes = ingRepo.findByNombre(nombrePlato);

        return listaIngredientes;

    }
}
