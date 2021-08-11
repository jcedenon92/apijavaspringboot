package com.nutritionapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "prediccion")
public class Prediccion {

	@Id
	@GeneratedValue
	private Integer idPrediccion;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_prediccion", nullable = false, length = 100)
	private Date fechaPrediccion;

	@ApiModelProperty(notes = "Cantidad de edad por mes en la prediccion debe tener minimo 3 caracteres")
	//@Size(min = 3 , message = "Cantidad de edad por mes en la prediccion debe tener minimo 3 caracteres")
	@Column(name = "edad_mes_prediccion", nullable = false, length = 50)
	private Integer edadMesPrediccion;

	@ApiModelProperty(notes = "Cantidad de peso en la prediccion debe tener minimo 3 caracteres")
	//@Size(min = 3 , message = "Cantidad de edad en la prediccion debe tener minimo 3 caracteres")
	@Column(name = "peso_prediccion", nullable = false, length = 50)
	private Double pesoPrediccion;

	@ApiModelProperty(notes = "Cantidad de estatura en la prediccion debe tener minimo 3 caracteres")
	//@Size(min = 3 , message = "Cantidad de estatura en la prediccion debe tener minimo 3 caracteres")
	@Column(name = "estatura_prediccion", nullable = false, length = 50)
	private Double estaturaPrediccion;

	@ApiModelProperty(notes = "Cantidad de cabeza en la prediccion debe tener minimo 3 caracteres")
	//@Size(min = 3 , message = "Cantidad de cabeza en la prediccion debe tener minimo 3 caracteres")
	@Column(name = "cabeza_prediccion", nullable = false, length = 50)
	private Double cabezaPrediccion;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_prediccion_paciente"))
	private Paciente paciente;

	public Integer getIdPrediccion() {
		return idPrediccion;
	}

	public void setIdPrediccion(Integer idPrediccion) {
		this.idPrediccion = idPrediccion;
	}

	public Date getFechaPrediccion() {
		return fechaPrediccion;
	}

	public void setFechaPrediccion(Date fechaPrediccion) {
		this.fechaPrediccion = fechaPrediccion;
	}

	public Integer getEdadMesPrediccion() {
		return edadMesPrediccion;
	}

	public void setEdadMesPrediccion(Integer edadMesPrediccion) {
		this.edadMesPrediccion = edadMesPrediccion;
	}

	public Double getPesoPrediccion() {
		return pesoPrediccion;
	}

	public void setPesoPrediccion(Double pesoPrediccion) {
		this.pesoPrediccion = pesoPrediccion;
	}

	public Double getEstaturaPrediccion() {
		return estaturaPrediccion;
	}

	public void setEstaturaPrediccion(Double estaturaPrediccion) {
		this.estaturaPrediccion = estaturaPrediccion;
	}

	public Double getCabezaPrediccion() {
		return cabezaPrediccion;
	}

	public void setCabezaPrediccion(Double cabezaPrediccion) {
		this.cabezaPrediccion = cabezaPrediccion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
