package com.zallpy.credit.service;

import java.net.URISyntaxException;
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
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private PropostaService propostaService;
	

	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado id: " + id + " Tipo: " + Cliente.class.getName()));
	}

	public boolean existe(Cliente cliente) {
		Boolean c = true;
		if(clienteRepository.findByCpf(cliente.getCpf()) != null) {
			c = false;
		};
		return c;
	}

	public Cliente buscarPerfilDeRisco(Cliente cliente) throws URISyntaxException {
		cliente = perfilService.avaliacaoPerfil(cliente);
		return cliente;
	}

	public void gerarProposta(Cliente clienteComPerfil) {
		propostaService.avaliacaoRisco(clienteComPerfil);
		
	}

}