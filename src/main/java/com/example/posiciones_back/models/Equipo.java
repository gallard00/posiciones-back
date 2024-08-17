package com.example.posiciones_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "equipo")
@Entity
@Getter
@Setter
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private Long id;
    private String nombre;
    private String localidad;
    private String categoria;
}
