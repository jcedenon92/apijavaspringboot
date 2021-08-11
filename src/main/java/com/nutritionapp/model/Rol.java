package com.nutritionapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;

	@ApiModelProperty(notes = "Nombre del Rol debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre del Rol debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@ApiModelProperty(notes = "Descripcion del Rol debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Descripcion del Rol debe tener minimo 3 caracteres")
	@Column(name = "descripcion", nullable = false, length = 250)
	private String descripcion;
/*
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = true, foreignKey = @ForeignKey(name = "FK_rol_usuario"))
	private Usuario usuario;
*/
	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/*
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
*/	
	

}
