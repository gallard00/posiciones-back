package com.example.posiciones_back.dtos.request;

import lombok.Data;

import java.util.Date;

@Data
public class PartidoRequest {

    private Long equipoLocal;
    private Long equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private Date fecha;

}
