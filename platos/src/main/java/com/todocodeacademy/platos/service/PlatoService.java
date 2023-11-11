package com.todocodeacademy.platos.service;

import com.todocodeacademy.platos.dto.IngredienteDTO;
import com.todocodeacademy.platos.model.Plato;
import com.todocodeacademy.platos.repository.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlatoService implements IPlatoService {
    @Autowired
    IPlatoRepository platoRepo;
    @Autowired
    RestTemplate apiIngrediente;

    @Override
    public List<Plato> getPlatos() {
        return platoRepo.findAll();
    }

    @Override
    public void savePlato(String nombre, Double precio, String descripcion){
        //traer Ingredientes
        Plato plato = new Plato();
        List<String> listaIngrePlato = new ArrayList<String>();
        plato.setNombre(nombre);
        plato.setPrecio(precio);
        plato.setDescripcion(descripcion);
        List<IngredienteDTO> listaIngredientes = Arrays.asList(apiIngrediente.getForObject("http://localhost:9004/ingredientes/traer/" + nombre, IngredienteDTO[].class));
        for (IngredienteDTO ingre : listaIngredientes) {
            listaIngrePlato.add(ingre.getNombre_ingrediente());
        }
        plato.setListaIngredientes(listaIngrePlato);
        platoRepo.save(plato);

    }

    @Override
    public void deletePlato(Long id) {
        platoRepo.deleteById(id);
    }

    @Override
    public Plato findPlato(Long id) {
        return platoRepo.findById(id).orElse(null);
    }

    @Override
    public void editPlato(Long id, Plato plato) {
        Plato pla = this.findPlato(id);

        pla.setNombre(plato.getNombre());
        pla.setDescripcion(plato.getDescripcion());
        pla.setPrecio(plato.getPrecio());
        pla.setListaIngredientes(plato.getListaIngredientes());

        platoRepo.save(pla);
    }

    @Override
    public Plato findPlatoDni(String dni) {
        return null;
    }
}
