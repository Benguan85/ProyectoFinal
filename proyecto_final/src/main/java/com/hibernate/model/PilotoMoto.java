package com.hibernate.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "piloto_moto")
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

	public PilotoMoto() {
		super();
	}

	public PilotoMoto(Piloto piloto, Moto moto, Date fecha) {
		super();
		this.piloto = piloto;
		this.moto = moto;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Moto getMoto() {
		return moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

    // Constructores, getters y setters...
    
}
