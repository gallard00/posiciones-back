package com.example.posiciones_back.repositories;

import com.example.posiciones_back.models.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRespository extends JpaRepository<Partido, Long> {
}
