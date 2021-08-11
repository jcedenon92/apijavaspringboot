package com.nutritionapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "vacuna")
public class Vacuna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVacuna;

	@ApiModelProperty(notes = "Nombre de vacuna debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre de vacuna debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 150)
	private String nombre;

	public Integer getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(Integer idVacuna) {
		this.idVacuna = idVacuna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
