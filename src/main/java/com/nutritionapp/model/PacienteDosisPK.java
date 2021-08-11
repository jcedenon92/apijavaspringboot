package com.nutritionapp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PacienteDosisPK implements Serializable{

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_dosis", nullable = false)
	private Dosis dosis;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dosis == null) ? 0 : dosis.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
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
		PacienteDosisPK other = (PacienteDosisPK) obj;
		if (dosis == null) {
			if (other.dosis != null)
				return false;
		} else if (!dosis.equals(other.dosis))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}

}
