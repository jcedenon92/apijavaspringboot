package com.nutritionapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dosis")
public class Dosis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDosis;

	@Column(name = "fecha_mes", nullable = false, length = 45)
	private Integer fechaMes;

	@ManyToOne
	@JoinColumn(name = "id_vacuna", nullable = false, foreignKey = @ForeignKey(name = "FK_dosis_vacuna"))
	private Vacuna vacuna;

	public Integer getIdDosis() {
		return idDosis;
	}

	public void setIdDosis(Integer idDosis) {
		this.idDosis = idDosis;
	}

	public Integer getFechaMes() {
		return fechaMes;
	}

	public void setFechaMes(Integer fechaMes) {
		this.fechaMes = fechaMes;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDosis == null) ? 0 : idDosis.hashCode());
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
		Dosis other = (Dosis) obj;
		if (idDosis == null) {
			if (other.idDosis != null)
				return false;
		} else if (!idDosis.equals(other.idDosis))
			return false;
		return true;
	}

}
