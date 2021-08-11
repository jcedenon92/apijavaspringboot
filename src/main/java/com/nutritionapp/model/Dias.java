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
@Table(name = "dias")
public class Dias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDias;

	@ApiModelProperty(notes = "Nombre de Dias debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre de Dias debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	public Integer getIdDias() {
		return idDias;
	}

	public void setIdDias(Integer idDias) {
		this.idDias = idDias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDias == null) ? 0 : idDias.hashCode());
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
		Dias other = (Dias) obj;
		if (idDias == null) {
			if (other.idDias != null)
				return false;
		} else if (!idDias.equals(other.idDias))
			return false;
		return true;
	}

}
