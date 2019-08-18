package com.zallpy.credit.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.zallpy.credit.model.Cliente;
import com.zallpy.credit.model.enums.PropostaSituacao;
import com.zallpy.credit.model.enums.SituacaoMotivo;

@Entity
public class Proposta {

	/**
	 * Author: Damianos Sotirakis Model: Proposta
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private PropostaSituacao situacao;
	@Enumerated(EnumType.STRING)
	private SituacaoMotivo motivo;
	
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

	public SituacaoMotivo getMotivo() {
		return motivo;
	}

	public void setMotivo(SituacaoMotivo motivo) {
		this.motivo = motivo;
	}
	public PropostaSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(PropostaSituacao situacao) {
		this.situacao = situacao;
	}

}
