package com.example.posiciones_back.dtos.response;

import lombok.Data;

import java.util.Date;

@Data
public class PartidoResponse {

    private Long id;
    private Long equipoLocal;
    private Long equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private Date fecha;
}
