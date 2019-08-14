package com.zallpy.credit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.zallpy.credit.model.Cliente;

@Entity
public class Perfil {

	/**
	 * Author: Damianos Sotirakis Model: Crédito
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer codigo;
	private Integer risco; //Baixo = 0 | M1 = 1 | M2 = 2 | M3 = 3 | Alto = 4
	private Double alcadaminima;
	private Double alcadamaxima;
	
	
	

	// Relacionamento perfil - cliente
	@ManyToMany(mappedBy = "perfis", cascade = CascadeType.ALL)
	private List<Cliente> clientes;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getRisco() {
		return risco;
	}

	public void setRisco(Integer risco) {
		this.risco = risco;
	}

	public Double getAlcadaminima() {
		return alcadaminima;
	}

	public void setAlcadaminima(Double alcadaminima) {
		this.alcadaminima = alcadaminima;
	}

	public Double getAlcadamaxima() {
		return alcadamaxima;
	}

	public void setAlcadamaxima(Double alcadamaxima) {
		this.alcadamaxima = alcadamaxima;
	}

	public List<Cliente> getCliente_id() {
		return clientes;
	}

	public void setCliente_id(List<Cliente> cliente_id) {
		this.clientes = cliente_id;
	}
	

}
