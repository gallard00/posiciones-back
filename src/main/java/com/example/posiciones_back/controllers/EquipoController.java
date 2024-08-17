package com.example.posiciones_back.controllers;

import com.example.posiciones_back.dtos.request.EquipoRequest;
import com.example.posiciones_back.dtos.response.EquipoResponse;
import com.example.posiciones_back.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @PostMapping
    public ResponseEntity<EquipoResponse> crearEquipo(@RequestBody EquipoRequest equipoRequest) {
        return ResponseEntity.ok(equipoService.crearEquipo(equipoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoResponse> getEquipoById(@PathVariable Long id) {
        return ResponseEntity.ok((equipoService.getEquipoById(id)));
    }

    @GetMapping
    public ResponseEntity<List<EquipoResponse>> getAllEquipos(){
        return ResponseEntity.ok(equipoService.getAllEquipo());
    }

    @PutMapping
    public ResponseEntity<EquipoResponse> updateEquipo(@PathVariable Long id, @RequestBody EquipoRequest equipoRequest){
        return ResponseEntity.ok(equipoService.updateEquipo(id, equipoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }
}
