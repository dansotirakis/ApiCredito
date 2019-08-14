package com.zallpy.credit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zallpy.credit.model.Cliente;
import com.zallpy.credit.repository.ClienteRepository;
import com.zallpy.credit.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	/**
	 * Author: Damianos Sotirakis 
	 * Service: Cliente
	 */

	@Autowired
	private ClienteRepository repository;

	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado id: " + id + " Tipo: " + Cliente.class.getName()));
	}

}