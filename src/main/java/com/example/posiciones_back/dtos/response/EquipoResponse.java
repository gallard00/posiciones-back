package com.example.posiciones_back.dtos.response;

import lombok.Data;

@Data
public class EquipoResponse {
    private Long id;
    private String nombre;
    private String localidad;
    private String categoria;
}
