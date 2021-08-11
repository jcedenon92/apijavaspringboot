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
@Table(name = "turnocomida")
public class TurnoComida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTurnoComida;

	@ApiModelProperty(notes = "Nombre del Turno de Comida debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre del Turno de Comida debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	public Integer getIdTurnoComida() {
		return idTurnoComida;
	}

	public void setIdTurnoComida(Integer idTurnoComida) {
		this.idTurnoComida = idTurnoComida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurnoComida == null) ? 0 : idTurnoComida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurnoComida other = (TurnoComida) obj;
		if (idTurnoComida == null) {
			if (other.idTurnoComida != null)
				return false;
		} else if (!idTurnoComida.equals(other.idTurnoComida))
			return false;
		return true;
	}*/
}
