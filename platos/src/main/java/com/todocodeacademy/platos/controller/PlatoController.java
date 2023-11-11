package com.todocodeacademy.platos.controller;

import com.todocodeacademy.platos.dto.PlatoDTO;
import com.todocodeacademy.platos.model.Plato;
import com.todocodeacademy.platos.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/platos")
public class PlatoController {
    @Autowired
    private IPlatoService platoService;

    //1- crear un nuevo plato
    @PostMapping("/crear")
    public String crearPlato (@RequestBody PlatoDTO plato) {


        platoService.savePlato(plato.getNombre(),plato.getPrecio(),plato.getDescripcion());

        return "El plato fue creado correctamente";
    }

    //2- traer todos los platos
    @GetMapping("/traer")
    public List<Plato> trearPlatos () {
        return platoService.getPlatos();
    }
    //3- Eliminar un plato
    @DeleteMapping("/borrar/{id}")
    public String deletePlato(@PathVariable Long id) {
        platoService.deletePlato(id);

        return "El platos fue eliminado correctamente";
    }

    //4- Editar un plato
    @PutMapping ("/editar/{id_original}")
    public Plato editPlato (@PathVariable Long id_original,
                                  @RequestBody Plato platoEditar) {

        platoService.editPlato(id_original, platoEditar);
        return platoService.findPlato(id_original);

    }

    //5- obtener un plato en particular
    @GetMapping ("/traerdni/{dni}")
    public Plato traerPlato (@PathVariable String dni) {
        return platoService.findPlatoDni(dni);
    }
}
