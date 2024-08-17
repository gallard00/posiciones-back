package com.example.posiciones_back.controllers;

import com.example.posiciones_back.dtos.request.PartidoRequest;
import com.example.posiciones_back.dtos.response.PartidoResponse;
import com.example.posiciones_back.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public ResponseEntity<PartidoResponse> crearPartido(@RequestBody PartidoRequest partidoRequest) {
        return ResponseEntity.ok(partidoService.crearPartido(partidoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoResponse> getPartidoById(@PathVariable Long id) {
        return ResponseEntity.ok(partidoService.getPartidoById(id));
    }

    @GetMapping
    public ResponseEntity<List<PartidoResponse>> getAllPartidos() {
        return ResponseEntity.ok(partidoService.getAllPartidos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidoResponse> updatePartido(@PathVariable Long id, @RequestBody PartidoRequest partidoRequest){
        return ResponseEntity.ok(partidoService.updatePartido(id, partidoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Long id) {
        partidoService.deletePartido(id);
        return ResponseEntity.noContent().build();
    }

}
