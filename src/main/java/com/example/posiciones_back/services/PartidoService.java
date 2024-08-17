package com.example.posiciones_back.services;

import com.example.posiciones_back.dtos.request.PartidoRequest;
import com.example.posiciones_back.dtos.response.PartidoResponse;
import com.example.posiciones_back.mappers.PartidoMapper;
import com.example.posiciones_back.models.Equipo;
import com.example.posiciones_back.models.Partido;
import com.example.posiciones_back.repositories.PartidoRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PartidoService {

    @Autowired
    private PartidoRespository partidoRespository;

    @Autowired
    private PartidoMapper partidoMapper;

    @Autowired
    private EquipoService equipoService;

    public PartidoResponse crearPartido(PartidoRequest partidoRequest) {
        Partido partido = partidoMapper.toModel(partidoRequest);
        partido = partidoRespository.save(partido);
        return partidoMapper.toResponse(partido);
    }

    public PartidoResponse getPartidoById(Long id) {
        Partido partido = partidoRespository.findById(id)
                .orElseThrow(()-> new RuntimeException("Partido no encontrado"));
        return partidoMapper.toResponse(partido);
    }

    public List<PartidoResponse> getAllPartidos(){
        return partidoRespository.findAll().stream()
                .map(partidoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PartidoResponse updatePartido(Long id, PartidoRequest partidoRequest) {
        Partido partido = partidoRespository.findById(id)
                .orElseThrow(()-> new RuntimeException("Partido no encontrado"));

        if (partidoRequest.getEquipoLocal() !=null) {
            Equipo equipoLocal = equipoService.getEquipoEntityById(partidoRequest.getEquipoLocal());
            partido.setEquipoLocal(equipoLocal);
        }

        if (partidoRequest.getEquipoVisitante() != null ) {
            Equipo equipoVisitante = equipoService.getEquipoEntityById(partidoRequest.getEquipoVisitante());
            partido.setEquipoVisitante(equipoVisitante);
        }

        partido.setGolesLocal(partidoRequest.getGolesLocal());
        partido.setGolesVisitante(partidoRequest.getGolesVisitante());
        partido.setFecha(partidoRequest.getFecha());

        partido = partidoRespository.save(partido);
        return partidoMapper.toResponse(partido);
    }

    public void deletePartido(Long id) {
        Partido partido = partidoRespository.findById(id)
                .orElseThrow(()-> new RuntimeException("Partido no encontrado"));
        partidoRespository.delete(partido);
    }
}
