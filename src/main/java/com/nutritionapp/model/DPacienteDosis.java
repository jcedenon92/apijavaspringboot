package com.nutritionapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "dpacientedosis")
@IdClass(PacienteDosisPK.class)
public class DPacienteDosis {

	@Id
	private Paciente paciente;

	@Id
	private Dosis dosis;
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Dosis getDosis() {
		return dosis;
	}

	public void setDosis(Dosis dosis) {
		this.dosis = dosis;
	}

}
