package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "moto")

public class Moto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "cilindrada")
	private int cilindrada;
	
	@Column(name = "caballos")
	private int caballos;

    @OneToMany(mappedBy = "moto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PilotoMoto> usos = new ArrayList<>();
	
	public Moto() {
		super();
	}

	public Moto(String marca, String modelo, int cilindrada, int caballos) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.caballos = caballos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

}
