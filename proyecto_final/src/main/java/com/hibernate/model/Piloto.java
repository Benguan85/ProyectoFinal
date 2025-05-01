package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "piloto")

public class Piloto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;

	@Column(name = "nombre")
	String nombre;

	@Column(name = "edad")
	int edad;

	@Column(name = "nacionalidad")
	String nacionalidad;

	@Column(name = "escuderia")
	String escuderia;

	@Column(name = "tiempo_vuelta")
	double tiempo_vuelta;

	public Piloto() {
		super();
	}

	public Piloto(String nombre, int edad, String nacionalidad, String escuderia, double tiempo_vuelta) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.escuderia = escuderia;
		this.tiempo_vuelta = tiempo_vuelta;
	}

    @OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PilotoMoto> participaciones = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	public double getTiempo_vuelta() {
		return tiempo_vuelta;
	}

	public void setTiempo_vuelta(double tiempo_vuelta) {
		this.tiempo_vuelta = tiempo_vuelta;
	}
}
