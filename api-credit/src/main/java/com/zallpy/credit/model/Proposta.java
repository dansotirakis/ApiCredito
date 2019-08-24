package com.zallpy.credit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proposta {

	/**
	 * Author: Damianos Sotirakis Model: Proposta
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String situacao;
	private String motivo;
	
	// Relacionamento cliente - proposta
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
