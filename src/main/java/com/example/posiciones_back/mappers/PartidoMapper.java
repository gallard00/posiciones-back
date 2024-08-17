package com.example.posiciones_back.mappers;

import com.example.posiciones_back.dtos.request.PartidoRequest;
import com.example.posiciones_back.dtos.response.PartidoResponse;
import com.example.posiciones_back.models.Equipo;
import com.example.posiciones_back.models.Partido;
import com.example.posiciones_back.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;

public class PartidoMapper {
    @Autowired
    private EquipoService equipoService;

    public Partido toModel(PartidoRequest partidoRequest) {
        Partido partido = new Partido();

        partido.setGolesLocal(partidoRequest.getGolesLocal());
        partido.setGolesVisitante(partidoRequest.getGolesVisitante());

        Equipo equipoLocal = equipoService.getEquipoEntityById(partidoRequest.getEquipoLocal());
        Equipo equipoVisitante = equipoService.getEquipoEntityById(partidoRequest.getEquipoVisitante());

        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);

        return partido;
    }

    public PartidoResponse toResponse(Partido partido) {
        PartidoResponse partidoResponse = new PartidoResponse();

        partidoResponse.setGolesLocal(partido.getGolesLocal());
        partidoResponse.setGolesVisitante(partido.getGolesVisitante());
        partidoResponse.setFecha(partido.getFecha());

        if (partido.getEquipoLocal() !=null) {
            partidoResponse.setEquipoLocal(partido.getEquipoLocal().getId());
        }
        if (partido.getEquipoVisitante() !=null) {
            partidoResponse.setEquipoVisitante(partido.getEquipoVisitante().getId());
        }

        return partidoResponse;

    }
}
