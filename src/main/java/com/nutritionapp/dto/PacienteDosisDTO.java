package com.nutritionapp.dto;

import java.util.List;

import com.nutritionapp.model.Dosis;
import com.nutritionapp.model.Paciente;

public class PacienteDosisDTO {

	private Paciente paciente;
	private List<Dosis> lstDosis;
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public List<Dosis> getLstDosis() {
		return lstDosis;
	}
	public void setLstDosis(List<Dosis> lstDosis) {
		this.lstDosis = lstDosis;
	}
	
	
}
