package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "piloto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "escuderia")
    private String escuderia;

    @Column(name = "tiempo_vuelta")
    private double tiempo_vuelta;

    @OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PilotoMoto> participaciones = new ArrayList<>();

    public Piloto(String nombre, int edad, String nacionalidad, String escuderia, double tiempo_vuelta) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.escuderia = escuderia;
        this.tiempo_vuelta = tiempo_vuelta;
    }
}

