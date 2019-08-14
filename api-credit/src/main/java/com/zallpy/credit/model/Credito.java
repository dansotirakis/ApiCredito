package com.zallpy.credit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.zallpy.credit.model.Cliente;

@Entity
public class Credito {

	/**
	 * Author: 	Damianos Sotirakis
	 * Model: 	Crédito
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String 	limite;
	private float	risco;
	
	//Relacionamento credito - cliente
		@ManyToOne
		@JoinColumn(name="cliente_id")
		private Cliente cliente;

		public String getLimite() {
			return limite;
		}

		public void setLimite(String limite) {
			this.limite = limite;
		}

		public float getRisco() {
			return risco;
		}

		public void setRisco(float risco) {
			this.risco = risco;
		}
	
	
	
}
