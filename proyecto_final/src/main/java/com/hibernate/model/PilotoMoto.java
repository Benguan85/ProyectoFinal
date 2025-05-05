package com.hibernate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "piloto_moto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PilotoMoto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_piloto", nullable = false)
	private Piloto piloto;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_moto", nullable = false)
	private Moto moto;

	@Column(name = "fecha")
	private Date fecha;

	public PilotoMoto(Piloto piloto, Moto moto, Date fecha) {
		this.piloto = piloto;
		this.moto = moto;
		this.fecha = fecha;
	}
}