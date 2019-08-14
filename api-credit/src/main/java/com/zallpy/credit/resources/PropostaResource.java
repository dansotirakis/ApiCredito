package com.zallpy.credit.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zallpy.credit.model.Proposta;
import com.zallpy.credit.service.PropostaService;

@RestController
@RequestMapping(value = "/propostas")
public class PropostaResource {

	/**
	 * Author: Damianos Sotirakis Resource: Proposta
	 */

	@Autowired
	private PropostaService propostaService;
	
	//PUT
		@RequestMapping(value = "/{cliente/{idCliente}", method = RequestMethod.PUT)
		public ResponseEntity<?> defineRisco(@PathVariable Integer idCliente){
			Proposta proposta = propostaService.avaliacaoRisco(idCliente);
			return ResponseEntity.ok().body(proposta);
		}
	
	//GET
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Proposta proposta = propostaService.buscar(id);
		return ResponseEntity.ok().body(proposta);
	}

}
