package com.nutritionapp.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalleplan")
public class DetallePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_plan", nullable = false, foreignKey = @ForeignKey(name = "FK_detalleplan_idplan"))
	private Plan plan;

	@ManyToOne
	@JoinColumn(name = "id_alimento", nullable = false, foreignKey = @ForeignKey(name = "FK_detalleplan_alimento"))
	private Alimento alimento;

	@ManyToOne
	@JoinColumn(name = "id_turno_comida", nullable = false, foreignKey = @ForeignKey(name = "FK_detalleplan_turnocomida"))
	private TurnoComida turnocomida;

	@ManyToOne
	@JoinColumn(name = "id_dias", nullable = false, foreignKey = @ForeignKey(name = "FK_detalleplan_dias"))
	private Dias dias;

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public TurnoComida getTurnocomida() {
		return turnocomida;
	}

	public void setTurnocomida(TurnoComida turnocomida) {
		this.turnocomida = turnocomida;
	}

	public Dias getDias() {
		return dias;
	}

	public void setDias(Dias dias) {
		this.dias = dias;
	}

}
