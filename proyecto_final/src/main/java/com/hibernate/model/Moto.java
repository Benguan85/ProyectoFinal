package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "moto")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

	public Moto(String marca, String modelo, int cilindrada, int caballos) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.caballos = caballos;
	}
}
