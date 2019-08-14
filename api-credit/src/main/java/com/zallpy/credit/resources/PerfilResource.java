package com.zallpy.credit.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zallpy.credit.model.Cliente;
import com.zallpy.credit.model.Perfil;
import com.zallpy.credit.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {
	
	/**
	 * Author: Damianos Sotirakis Resource: Perfil
	 */

	@Autowired
	private PerfilService perfilService;
	
	//PUT
	@RequestMapping(value = "/{cliente/{idCliente}", method = RequestMethod.PUT)
	public ResponseEntity<?> definePerfil(@PathVariable Integer idCliente){
		Cliente cliente = perfilService.avaliacaoPerfil(idCliente);
		return ResponseEntity.ok().body(cliente);
	}
	
	//GET
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Perfil perfil = perfilService.buscar(id);
		return ResponseEntity.ok().body(perfil);
	}
	
	@RequestMapping(value="/perfil/{idCliente}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarPerfilCliente(@PathVariable Integer id){
		Perfil perfil = perfilService.buscar(id);
		return ResponseEntity.ok().body(perfil);
	}
	
}
