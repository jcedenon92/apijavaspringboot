package com.nutritionapp.model;

import java.util.Date;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;

	@ApiModelProperty(notes = "Nombres de Paciente debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombres de Paciente debe tener minimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 250)
	private String nombres;

	@ApiModelProperty(notes = "Fecha de Nacimiento del paciente debe tener minimo 3 caracteres")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_nacimiento", nullable = false, length = 50)
	private Date fechaNacimiento;

	@Size(min = 3, message = "Sexo debe tener mínimo 3 caracteres")
	@Column(name = "sexo", nullable = false, length = 50)
	private String sexo;

	@ApiModelProperty(notes = "Cantidad de semanas de gestacion debe tener minimo 3 caracteres")
	//@Size(min = 1, message = "Cantidad de semanas de gestacion debe tener minimo 3 caracteres")
	@Column(name = "semana_gestacion", nullable = false, length = 50)
	private Integer semanaGestacion;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_paciente_usuario"))
	private Usuario usuario;

	//No se mapea en bd, solo es una representacion logica
	//mappedBy busca el nombre del atributo de la otra tabla con la que hará match
	//@OneToMany(mappedBy = "paciente", cascade = { CascadeType.ALL }, orphanRemoval = true)
	//private List<Control> lstControles;

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getSemanaGestacion() {
		return semanaGestacion;
	}

	public void setSemanaGestacion(Integer semanaGestacion) {
		this.semanaGestacion = semanaGestacion;
	}
/*
	public List<Control> getLstControles() {
		return lstControles;
	}

	public void setLstControles(List<Control> lstControles) {
		this.lstControles = lstControles;
	}
	*/
}
