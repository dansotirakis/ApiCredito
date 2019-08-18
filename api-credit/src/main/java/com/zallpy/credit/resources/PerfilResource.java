package com.zallpy.credit.resources;

import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zallpy.credit.model.Perfil;
import com.zallpy.credit.repository.PerfilRepository;
import com.zallpy.credit.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

	/**
	 * Author: Damianos Sotirakis Resource: Perfil
	 */

	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private PerfilRepository perfilRepository;

	// CADASTRO
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Optional<Perfil> perfil) throws URISyntaxException {
		if (perfilService.existe(perfil.get())) {
			return new ResponseEntity<>(perfil,HttpStatus.ALREADY_REPORTED);
		}
		perfilRepository.save(perfil.get());
		return ResponseEntity.ok().body(perfil);
	}
	
	// CONSULTA
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Perfil perfil = perfilService.buscar(id);
		if (perfil != null) {
			return ResponseEntity.ok().body(perfil);
		}
		return new ResponseEntity<>(perfil, HttpStatus.NOT_FOUND);
	}
	
	//EDIÇÃO
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody Perfil perfil) {
		if (perfilService.buscar(perfil.getId()) != null) {
			perfilRepository.save(perfil);
			return ResponseEntity.ok().body(perfil);
		}

		return new ResponseEntity<>(perfil,HttpStatus.BAD_REQUEST);
	}
	
	// COLSULTA POR CLIENTE
		@RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.GET)
		public ResponseEntity<?> consultarPerfilCliente(@PathVariable Integer idCliente) {
			Perfil perfil = perfilService.buscarPorCliente(idCliente);
			if (perfil != null) {
				return ResponseEntity.ok().body(perfil);
			}
			return new ResponseEntity<>(perfil, HttpStatus.NOT_FOUND);
		}
}
