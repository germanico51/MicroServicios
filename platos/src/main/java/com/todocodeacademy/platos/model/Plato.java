package com.todocodeacademy.platos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plato;
    private String nombre;
    private Double precio;
    private String descripcion;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> listaIngredientes;
}
