package com.example.posiciones_back.dtos.request;

import lombok.Data;

@Data
public class EquipoRequest {
    private String nombre;
    private String localidad;
    private String categoria;
}
