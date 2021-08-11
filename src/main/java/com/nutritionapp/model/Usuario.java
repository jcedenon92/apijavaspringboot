package com.nutritionapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Usuario")
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	/*
	 * @ApiModelProperty(notes = "Nombres deben tener mínimo 3 caracteres")
	 * 
	 * @Size(min = 3, message = "Nombres deben tener mínimo 3 caracteres")
	 * 
	 * @Column(name = "nombres", nullable = false, length = 100) private String
	 * nombres;
	 * 
	 * @ApiModelProperty(notes = "Apellidos deben tener mínimo 3 caracteres")
	 * 
	 * @Size(min = 3, message = "Apellidos deben tener mínimo 3 caracteres")
	 * 
	 * @Column(name = "apellidos", nullable = false, length = 100) private String
	 * apellidos;
	 * 
	 * @ApiModelProperty(notes = "Fecha de nacimiento de Usuario")
	 * 
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @DateTimeFormat(iso = ISO.DATE)
	 * 
	 * @Column(name = "fecha_nacimiento", nullable = true) private Date
	 * fechaNacimiento;
	 */
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;
	/*
	 * @Email
	 * 
	 * @Column(name = "email", nullable = false, length = 50) private String email;
	 * 
	 * @ApiModelProperty(notes =
	 * "Direccion deben tener mínimo 3 caracteres y puede ser null")
	 * 
	 * @Size(min = 3, message = "Dirección debe tener mínimo 3 caracteres")
	 * 
	 * @Column(name = "direccion", nullable = true, length = 150) private String
	 * direccion;
	 * 
	 * @ApiModelProperty(notes =
	 * "Telefono deben tener mínimo 3 caracteres y puede ser null")
	 * 
	 * @Size(min = 3, message = "Telefono deben tener mínimo 3 caracteres")
	 * 
	 * @Column(name = "telefono", nullable = true, length = 50) private String
	 * telefono;
	 */
	@ApiModelProperty(notes = "Estado true o false segun este activo o desactivado")
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	/*
	 * @Column(name = "foto_url", nullable = true) private String fotoUrl;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_rol", nullable = false, foreignKey = @ForeignKey(name
	 * = "FK_usuario_rol")) private Integer rol;
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}


	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name =
	 * "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns
	 * = @JoinColumn(name = "id_rol", referencedColumnName = "idRol")) private Rol
	 * rol;
	 */

}
