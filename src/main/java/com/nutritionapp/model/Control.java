package com.nutritionapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "control")
public class Control {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idControl;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_control", nullable = true, length = 100)
	private Date fechaControl;

	@ApiModelProperty(notes = "Cantidad de edad por mes debe tener minimo 3 caracteres")
	//@Size(min = 3 , message = "Cantidad de edad por mes debe tener minimo 3 caracteres")
	@Column(name = "edad_mes", nullable = false, length = 50)
	private Integer edadMes;

	@ApiModelProperty(notes = "Cantidad de peso debe tener minimo 3 caracteres")
	//@Size(min = 3 , message = "Cantidad de peso debe tener minimo 3 caracteres")
	@Column(name = "peso", nullable = false, length = 50)
	private Double peso;

	@ApiModelProperty(notes = "Cantidad de estatura debe tener minimo 3 caracteres")
	//@Size(min = 3 , message = "Cantidad de estatura debe tener minimo 3 caracteres")
	@Column(name = "estatura", nullable = false, length = 50)
	private Double estatura;

	@ApiModelProperty(notes = "Cantidad de medida de cabeza debe tener minimo 3 caracteres")
	//@Size(min = 3 , message = "Cantidad de medida de cabeza debe tener minimo 3 caracteres")
	@Column(name = "cabeza", nullable = false, length = 50)
	private Double cabeza;

	@ApiModelProperty(notes = "Cantidad de observacion debe tener minimo 3 caracteres y puede ser null")
	@Size(min = 3 , message = "Cantidad de observacion debe tener minimo 3 caracteres y puede ser null")
	@Column(name = "observacion", nullable = true, length = 250)
	private String observacion;

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_control_paciente"))
	private Paciente paciente;

	public Integer getIdControl() {
		return idControl;
	}

	public void setIdControl(Integer idControl) {
		this.idControl = idControl;
	}

	public Date getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	public Integer getEdadMes() {
		return edadMes;
	}

	public void setEdadMes(Integer edadMes) {
		this.edadMes = edadMes;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public Double getCabeza() {
		return cabeza;
	}

	public void setCabeza(Double cabeza) {
		this.cabeza = cabeza;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
