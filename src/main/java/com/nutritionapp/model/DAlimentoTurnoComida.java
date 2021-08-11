package com.nutritionapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "dalimentoturnocomida")
@IdClass(AlimentoTurnoComidaPK.class)
public class DAlimentoTurnoComida {

	@Id
	private Alimento alimento;

	@Id
	private TurnoComida turnocomida;

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

}
