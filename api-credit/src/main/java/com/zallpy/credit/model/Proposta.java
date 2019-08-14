package com.zallpy.credit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.zallpy.credit.model.Cliente;

@Entity
public class Proposta {

	/**
	 * Author: Damianos Sotirakis Model: Crédito
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer sit;

	// Relacionamento cliente - proposta
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Integer getSit() {
		return sit;
	}

	public void setSit(Integer sit) {
		this.sit = sit;
	}

	

}
