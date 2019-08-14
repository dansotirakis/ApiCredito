package com.zallpy.credit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zallpy.credit.model.Proposta;
import com.zallpy.credit.repository.PropostaRepository;
import com.zallpy.credit.service.exceptions.ObjectNotFoundException;

@Service
public class PropostaService {

	/**
	 * Author: Damianos Sotirakis Service: Proposta
	 */

	@Autowired
	private PropostaRepository propostaRepository;


	public Proposta buscar(Integer id) {
		Optional<Proposta> proposta = propostaRepository.findById(id);
		return proposta.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado id: " + id + " Tipo: " + Proposta.class.getName()));
	}


	public Proposta avaliacaoRisco(Integer idCliente) {

		/*
		 * Criar aqui método para avaliar o risco a partir do cliente / perfil
		 */
		
		return null;
	}

}
