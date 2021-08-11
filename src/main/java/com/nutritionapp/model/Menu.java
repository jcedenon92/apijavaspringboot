package com.nutritionapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	private Integer idMenu;

	@ApiModelProperty(notes = "Nombre del Menu debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre del Menu debe tener minimo 3 caracteres")
	@Column(name = "nombre", length = 200)
	private String nombre;

	@ApiModelProperty(notes = "Url del Menu debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Url del Menu debe tener minimo 3 caracteres")
	@Column(name = "url", length = 200)
	private String url;

	@ApiModelProperty(notes = "Icono del Menu debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Icono del Menu debe tener minimo 3 caracteres")
	@Column(name = "icono", length = 200)
	private String icono;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "idMenu"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}
