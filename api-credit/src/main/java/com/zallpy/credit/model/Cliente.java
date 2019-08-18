package com.zallpy.credit.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente implements Serializable {

	/**
	 * Author: Damianos Sotirakis Model: Cliente
	 */

	private static final long serialVersionUID = -8980886262088426230L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer dependerntes; 
	private Long cpf;
	private char sexo;
	private Integer estadocivil;
	private String uf;
	private double renda;
	private Integer idade;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Perfil perfil;

	// Gettings and Settings
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(Integer estadocivil) {
		this.estadocivil = estadocivil;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public Integer getDependerntes() {
		return dependerntes;
	}

	public void setDependerntes(Integer dependerntes) {
		this.dependerntes = dependerntes;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
