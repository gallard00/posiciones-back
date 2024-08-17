package com.example.posiciones_back.services;

import com.example.posiciones_back.dtos.request.EquipoRequest;
import com.example.posiciones_back.dtos.response.EquipoResponse;
import com.example.posiciones_back.mappers.EquipoMapper;
import com.example.posiciones_back.models.Equipo;
import com.example.posiciones_back.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private EquipoMapper equipoMapper;

    public EquipoResponse crearEquipo (EquipoRequest request) {
        Equipo equipo = equipoMapper.toModel(request);
        equipo = equipoRepository.save(equipo);
        return equipoMapper.toResponse(equipo);
    }

    public EquipoResponse getEquipoById (Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        return equipoMapper.toResponse(equipo);
    }

    public Equipo getEquipoEntityById(Long id) {
        return equipoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Equipo no encontrado"));
    }

    public List<EquipoResponse> getAllEquipo(){
        return equipoRepository.findAll().stream()
                .map(equipoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public EquipoResponse updateEquipo(Long id, EquipoRequest request) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        equipo.setNombre(request.getNombre());
        equipo.setCategoria(request.getCategoria());
        equipo.setLocalidad(request.getLocalidad());

        equipo = equipoRepository.save(equipo);
        return equipoMapper.toResponse(equipo);
    }

    public void deleteEquipo(Long id){
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Equipo no encontrado"));
        equipoRepository.delete(equipo);
    }
}
