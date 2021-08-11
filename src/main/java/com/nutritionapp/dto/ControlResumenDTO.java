package com.nutritionapp.dto;

public class ControlResumenDTO {

	private Double peso;
	private String fecha;

	public ControlResumenDTO() {
	}

	public ControlResumenDTO(Double peso, String fecha) {
		super();
		this.peso = peso;
		this.fecha = fecha;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
