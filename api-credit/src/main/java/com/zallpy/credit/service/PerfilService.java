package com.zallpy.credit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zallpy.credit.model.Cliente;
import com.zallpy.credit.model.Perfil;
import com.zallpy.credit.repository.ClienteRepository;
import com.zallpy.credit.repository.PerfilRepository;
import com.zallpy.credit.service.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {

	/**
	 * Author: Damianos Sotirakis Service: Perfil
	 */

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public Perfil buscar(Integer id) {
		Optional<Perfil> perfil = perfilRepository.findById(id);
		return perfil.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado id: " + id + " Tipo: " + Perfil.class.getName()));
	}

	public Cliente avaliacaoPerfil(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		
		/*
		 * Colocar aqui a regra para avaliação do perfil a partir dos atributos do cliente
		 */
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado id: " + idCliente + " Tipo: " + Cliente.class.getName()));
	}
}
