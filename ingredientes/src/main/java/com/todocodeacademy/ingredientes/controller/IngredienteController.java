package com.todocodeacademy.ingredientes.controller;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import com.todocodeacademy.ingredientes.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {
    @Autowired
    private IIngredienteService ingredienteService;

    //1- crear un nuevo paciente
    @PostMapping("/crear")
    public String crearIngrediente (@RequestBody Ingrediente ing) {
        ingredienteService.saveIngrediente(ing);

        return "El ingrediente fue creado correctamente";
    }

    //2- traer todos los pacientes
    @GetMapping("/traer")
    public List<Ingrediente> TrearIngredientes () {
        return ingredienteService.getIngredientes();
    }
    //3- Eliminar un ingrediente
    @DeleteMapping("/borrar/{id}")
    public String deleteIngrediente(@PathVariable Long id) {
        ingredienteService.deleteIngrediente(id);

        return "El ingredientes fue eliminado correctamente";
    }

    //4- Editar un ingrediente
    @PutMapping ("/editar/{id_original}")
    public Ingrediente editIngrediente (@PathVariable Long id_original,
                                  @RequestBody Ingrediente ingEditar) {

        ingredienteService.editIngrediente(id_original, ingEditar);

        return ingredienteService.findIngrediente(id_original);

    }

    //5- obtener un ingrediente en particular
    @GetMapping ("/traer/{nombre_plato}")
    public List<Ingrediente> traerIngrediente (@PathVariable String nombre_plato) {
        return ingredienteService.findByPlato(nombre_plato);
    }
}
