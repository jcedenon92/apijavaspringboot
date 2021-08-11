package com.nutritionapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "plan")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlan;

	@ApiModelProperty(notes = "Fecha de Inicio del plan")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_inicio", nullable = false, length = 50)
	private Date fechaInicio;

	@ApiModelProperty(notes = "Fecha de Fin del plan")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_fin", nullable = false, length = 50)
	private Date fechaFin;

	@ApiModelProperty(notes = "El objetivo ingresado debe tener minimo 3 caracteres")
	@Size(min = 3, message = "El objetivo ingresado debe tener minimo 3 caracteres")
	@Column(name = "objetivo", nullable = false, length = 100)
	private String objetivo;

	@ApiModelProperty(notes = "Se ingresa true o false para la actividad del plan nutricional")
	@Column(name = "estado", nullable = false, length = 50)
	private boolean activo;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_plan_paciente"))
	private Paciente paciente;

	/*@OneToMany(mappedBy = "plan", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Dias> lstDias;
*/
	@OneToMany(mappedBy = "plan", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetallePlan> lstDetallePlanes;

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<DetallePlan> getLstDetallePlanes() {
		return lstDetallePlanes;
	}

	public void setLstDetallePlanes(List<DetallePlan> lstDetallePlanes) {
		this.lstDetallePlanes = lstDetallePlanes;
	}
/*
	public List<Dias> getLstDias() {
		return lstDias;
	}

	public void setLstDias(List<Dias> lstDias) {
		this.lstDias = lstDias;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlan == null) ? 0 : idPlan.hashCode());
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
		Plan other = (Plan) obj;
		if (idPlan == null) {
			if (other.idPlan != null)
				return false;
		} else if (!idPlan.equals(other.idPlan))
			return false;
		return true;
	}
}
