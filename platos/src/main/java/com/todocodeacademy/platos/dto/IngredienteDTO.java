package com.todocodeacademy.platos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDTO {
    private Long id_ingrediente;
    private String nombre_ingrediente;
    private List<String> platos;
}
