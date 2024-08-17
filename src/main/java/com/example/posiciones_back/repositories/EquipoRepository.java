package com.example.posiciones_back.repositories;

import com.example.posiciones_back.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
