package com.nutritionapp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AlimentoTurnoComidaPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "id_alimento", nullable = false)
	private Alimento alimento;

	@ManyToOne
	@JoinColumn(name = "id_turno_comida", nullable = false)
	private TurnoComida turnocomida;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alimento == null) ? 0 : alimento.hashCode());
		result = prime * result + ((turnocomida == null) ? 0 : turnocomida.hashCode());
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
		AlimentoTurnoComidaPK other = (AlimentoTurnoComidaPK) obj;
		if (alimento == null) {
			if (other.alimento != null)
				return false;
		} else if (!alimento.equals(other.alimento))
			return false;
		if (turnocomida == null) {
			if (other.turnocomida != null)
				return false;
		} else if (!turnocomida.equals(other.turnocomida))
			return false;
		return true;
	}

}
