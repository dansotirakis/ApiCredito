package com.zallpy.credit.resources;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zallpy.credit.model.Cliente;
import com.zallpy.credit.repository.ClienteRepository;
import com.zallpy.credit.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	/**
	 * Author: Damianos Sotirakis Resource: Cliente
	 */

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	//CADASTRO CLIENTE - PERFIL - PROPOSTA
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Optional<Cliente> cliente) throws URISyntaxException {
		if (!clienteService.existe(cliente.get())) {
			return new ResponseEntity<>(cliente,HttpStatus.ALREADY_REPORTED);
		}
		Cliente clienteComPerfil = clienteService.buscarPerfilDeRisco(cliente.get());
		clienteRepository.save(clienteComPerfil);
		clienteService.gerarProposta(clienteComPerfil);
		return ResponseEntity.ok().body(clienteComPerfil);
	}
	
	//CONSULTA LISTA DE CLIENTES
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Cliente> clienteList = clienteRepository.findAll();
		
		return ResponseEntity.ok().body(clienteList);
		
	}
		
		
	//CONSULTA
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/{idCliente}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer idCliente) {
		Cliente cliente = clienteService.buscar(idCliente);
		if(cliente != null) {
		return ResponseEntity.ok().body(cliente);
		}
		return new ResponseEntity<>(cliente,HttpStatus.NOT_FOUND);
	}
	
	//EDIÇÃO
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody Cliente cliente) {
		if (clienteService.buscar(cliente.getId()) != null) {
			clienteRepository.save(cliente);
			return ResponseEntity.ok().body(cliente);
		}

		return new ResponseEntity<>(cliente,HttpStatus.BAD_REQUEST);
	}

}