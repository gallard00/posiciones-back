package com.example.posiciones_back.mappers;

import com.example.posiciones_back.dtos.request.EquipoRequest;
import com.example.posiciones_back.dtos.response.EquipoResponse;
import com.example.posiciones_back.models.Equipo;

public class EquipoMapper {

    public Equipo toModel(EquipoRequest equipoRequest) {
        Equipo equipo = new Equipo();

        equipo.setNombre(equipoRequest.getNombre());
        equipo.setLocalidad(equipoRequest.getLocalidad());
        equipo.setCategoria(equipoRequest.getCategoria());
        return equipo;
    }

    public EquipoResponse toResponse(Equipo equipo) {
        EquipoResponse equipoResponse = new EquipoResponse();

        equipoResponse.setId(equipo.getId());
        equipoResponse.setNombre(equipo.getNombre());
        equipoResponse.setLocalidad(equipo.getLocalidad());
        equipoResponse.setCategoria(equipo.getCategoria());

        return equipoResponse;
    }
}
