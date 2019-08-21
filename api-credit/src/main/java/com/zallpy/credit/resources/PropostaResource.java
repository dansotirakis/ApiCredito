package com.zallpy.credit.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zallpy.credit.model.Proposta;
import com.zallpy.credit.repository.PropostaRepository;
import com.zallpy.credit.service.PropostaService;

@RestController
@RequestMapping(value = "/proposta")
public class PropostaResource {

	/**
	 * Author: Damianos Sotirakis Resource: Proposta
	 */

	@Autowired
	private PropostaService propostaService;
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	//CONSULTA LISTA DE PROPOSTAS
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Proposta> propostaList = propostaRepository.findAll();
		
		return ResponseEntity.ok().body(propostaList);
		
	}
	
	//CONSULTA
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Proposta proposta = propostaService.buscar(id);
		if(proposta != null) {
			return ResponseEntity.ok().body(proposta);
		}
		return new ResponseEntity<>(proposta, HttpStatus.NOT_FOUND);
	}

	//CONSULTA PROPOSTA POR CLIENTE
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.GET)
	public ResponseEntity<?> buscaPropostaCliente(@PathVariable Integer idCliente){
		Proposta proposta = propostaService.buscarPorCliente(idCliente);
		if(proposta != null) {
			return ResponseEntity.ok().body(proposta);
		}
		return new ResponseEntity<>(proposta, HttpStatus.NOT_FOUND);
	}
}
