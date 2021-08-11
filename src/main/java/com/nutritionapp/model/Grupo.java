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
@Table(name = "grupo")
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGrupo;

	@ApiModelProperty(notes = "Nombre de Grupos de alimentos debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre de Grupos de alimentos debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 250)
	private String nombre;

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
