package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * <h2>Clase Piloto</h2>
 * Esta clase representa a un piloto con sus datos
 * 
 * @author Diego Alcalde Tebar
 * @version 1.0
 */
@Entity
@Table(name = "piloto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

    /**
     * Indica el ID del piloto
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * Nombre del piloto
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * Edad del piloto
     */
    @Column(name = "edad")
    private int edad;

    /**
     * Nacionalidad del piloto
     */
    @Column(name = "nacionalidad")
    private String nacionalidad;

    /**
     * Escuderia del piloto
     */
    @Column(name = "escuderia")
    private String escuderia;

    /**
     * Tiempo de vuelta
     */
    @Column(name = "tiempo_vuelta")
    private double tiempo_vuelta;

    /**
     * Lista de participaciones del piloto con diferentes motos
     */
    @OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PilotoMoto> participaciones = new ArrayList<>();

    /**
     * Constructor que permite crear un objeto Piloto sin especificar el ID
     * 
     * @param nombre Nombre del piloto
     * @param edad Edad del piloto
     * @param nacionalidad Nacionalidad del piloto
     * @param escuderia Escuderia del piloto
     * @param tiempo_vuelta Tiempo de vuelta
     */
    public Piloto(String nombre, int edad, String nacionalidad, String escuderia, double tiempo_vuelta) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.escuderia = escuderia;
        this.tiempo_vuelta = tiempo_vuelta;
    }
}

