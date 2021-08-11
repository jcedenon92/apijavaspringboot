package com.nutritionapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "alimento")
public class Alimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlimento;
	
	@ApiModelProperty(notes = "Nombre de Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre de Alimento debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 250)
	private String nombre;

	@ApiModelProperty(notes = "Cantidad en gramos de Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad en gramos de Alimento debe tener minimo 3 caracteres")
	@Column(name = "cantidad", nullable = false, length = 50)
	private String cantidad;

	@ApiModelProperty(notes = "Cantidad de energyKcal en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de energyKcal en Alimento debe tener minimo 3 caracteres")
	@Column(name = "energy_kcal", nullable = false, length = 50)
	private String energyKcal;

	@ApiModelProperty(notes = "Cantidad de energyKj en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de energyKj en Alimento debe tener minimo 3 caracteres")
	@Column(name = "energy_kj", nullable = false, length = 50)
	private String energyKj;

	@ApiModelProperty(notes = "Cantidad de agua en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de agua en Alimento debe tener minimo 3 caracteres")
	@Column(name = "water", nullable = false, length = 50)
	private String water;

	@ApiModelProperty(notes = "Cantidad de proteina en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de proteina en Alimento debe tener minimo 3 caracteres")
	@Column(name = "prot", nullable = false, length = 50)
	private String prot;

	@ApiModelProperty(notes = "Cantidad de grasas en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de grasas en Alimento debe tener minimo 3 caracteres")
	@Column(name = "fat", nullable = false, length = 50)
	private String fat;

	@ApiModelProperty(notes = "Cantidad de carbohidratos en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de carbohidratos en Alimento debe tener minimo 3 caracteres")
	@Column(name = "cho_cdf", nullable = false, length = 50)
	private String choCdf;

	@ApiModelProperty(notes = "Cantidad de carbohidratos disponible en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de carbohidratos disponible en Alimento debe tener minimo 3 caracteres")
	@Column(name = "cho_avl", nullable = false, length = 50)
	private String choAvl;

	@ApiModelProperty(notes = "Cantidad de fibra cruda en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de fibra cruda en Alimento debe tener minimo 3 caracteres")
	@Column(name = "fib", nullable = false, length = 50)
	private String fib;

	@ApiModelProperty(notes = "Cantidad de fibra dietaria en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de fibra dietaria en Alimento debe tener minimo 3 caracteres")
	@Column(name = "fib_tg", nullable = false, length = 50)
	private String fibTg;
	
	@ApiModelProperty(notes = "Cantidad de cenizas en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de cenizas en Alimento debe tener minimo 3 caracteres")
	@Column(name = "ash", nullable = false, length = 50)
	private String ash;

	@ApiModelProperty(notes = "Cantidad de calcio en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de calcio en Alimento debe tener minimo 3 caracteres")
	@Column(name = "ca", nullable = false, length = 50)
	private String ca;

	@ApiModelProperty(notes = "Cantidad de fosforo en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de fosforo en Alimento debe tener minimo 3 caracteres")
	@Column(name = "p", nullable = false, length = 50)
	private String p;

	@ApiModelProperty(notes = "Cantidad de zinc en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de zinc en Alimento debe tener minimo 3 caracteres")
	@Column(name = "zn", nullable = false, length = 50)
	private String zn;
	
	@ApiModelProperty(notes = "Cantidad de hierro en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de hierro en Alimento debe tener minimo 3 caracteres")
	@Column(name = "fe", nullable = false, length = 50)
	private String fe;

	@ApiModelProperty(notes = "Cantidad de beta caroteno en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de beta caroteno en Alimento debe tener minimo 3 caracteres")
	@Column(name = "beta", nullable = false, length = 50)
	private String beta;

	@ApiModelProperty(notes = "Cantidad de retinol en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de retinol en Alimento debe tener minimo 3 caracteres")
	@Column(name = "retinol", nullable = false, length = 50)
	private String retinol;

	@ApiModelProperty(notes = "Cantidad de Vitamina A en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de Vitamina A en Alimento debe tener minimo 3 caracteres")
	@Column(name = "vit_a", nullable = false, length = 50)
	private String vitA;

	@ApiModelProperty(notes = "Cantidad de Tiamina en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de Tiamina en Alimento debe tener minimo 3 caracteres")
	@Column(name = "thia", nullable = false, length = 50)
	private String thia;

	@ApiModelProperty(notes = "Cantidad de Riboflavina en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de Riboflavina en Alimento debe tener minimo 3 caracteres")
	@Column(name = "ribf", nullable = false, length = 50)
	private String ribf;

	@ApiModelProperty(notes = "Cantidad de Niacina en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de Niacina en Alimento debe tener minimo 3 caracteres")
	@Column(name = "nia", nullable = false, length = 50)
	private String nia;

	@ApiModelProperty(notes = "Cantidad de Vitamina C en Alimento debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Cantidad de Vitamina C en Alimento debe tener minimo 3 caracteres")
	@Column(name = "vit_c", nullable = false, length = 50)
	private String vitC;

	@OneToOne
	@JoinColumn(name = "id_grupo", nullable = false, foreignKey = @ForeignKey(name = "FK_alimento_grupo"))
	private Grupo grupo;

	public Integer getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(Integer idAlimento) {
		this.idAlimento = idAlimento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getEnergyKcal() {
		return energyKcal;
	}

	public void setEnergyKcal(String energyKcal) {
		this.energyKcal = energyKcal;
	}

	public String getEnergyKj() {
		return energyKj;
	}

	public void setEnergyKj(String energyKj) {
		this.energyKj = energyKj;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getProt() {
		return prot;
	}

	public void setProt(String prot) {
		this.prot = prot;
	}

	public String getFat() {
		return fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getChoCdf() {
		return choCdf;
	}

	public void setChoCdf(String choCdf) {
		this.choCdf = choCdf;
	}

	public String getChoAvl() {
		return choAvl;
	}

	public void setChoAvl(String choAvl) {
		this.choAvl = choAvl;
	}

	public String getFib() {
		return fib;
	}

	public void setFib(String fib) {
		this.fib = fib;
	}

	public String getFibTg() {
		return fibTg;
	}

	public void setFibTg(String fibTg) {
		this.fibTg = fibTg;
	}

	public String getAsh() {
		return ash;
	}

	public void setAsh(String ash) {
		this.ash = ash;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getZn() {
		return zn;
	}

	public void setZn(String zn) {
		this.zn = zn;
	}

	public String getFe() {
		return fe;
	}

	public void setFe(String fe) {
		this.fe = fe;
	}

	public String getBeta() {
		return beta;
	}

	public void setBeta(String beta) {
		this.beta = beta;
	}

	public String getRetinol() {
		return retinol;
	}

	public void setRetinol(String retinol) {
		this.retinol = retinol;
	}

	public String getVitA() {
		return vitA;
	}

	public void setVitA(String vitA) {
		this.vitA = vitA;
	}

	public String getThia() {
		return thia;
	}

	public void setThia(String thia) {
		this.thia = thia;
	}

	public String getRibf() {
		return ribf;
	}

	public void setRibf(String ribf) {
		this.ribf = ribf;
	}

	public String getNia() {
		return nia;
	}

	public void setNia(String nia) {
		this.nia = nia;
	}

	public String getVitC() {
		return vitC;
	}

	public void setVitC(String vitC) {
		this.vitC = vitC;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAlimento == null) ? 0 : idAlimento.hashCode());
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
		Alimento other = (Alimento) obj;
		if (idAlimento == null) {
			if (other.idAlimento != null)
				return false;
		} else if (!idAlimento.equals(other.idAlimento))
			return false;
		return true;
	}

}
