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
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Optional<Perfil> perfil) throws URISyntaxException {
		if (perfilService.existe(perfil.get())) {
			return new ResponseEntity<>(perfil,HttpStatus.ALREADY_REPORTED);
		}
		perfilRepository.save(perfil.get());
		return ResponseEntity.ok().body(perfil);
	}
	
	//CONSULTA LISTA DE PERFILS
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Perfil> perfilList = perfilRepository.findAll();
		
		return ResponseEntity.ok().body(perfilList);
		
	}
	
	// CONSULTA
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Perfil perfil = perfilService.buscar(id);
		if (perfil != null) {
			return ResponseEntity.ok().body(perfil);
		}
		return new ResponseEntity<>(perfil, HttpStatus.NOT_FOUND);
	}
	
	//EDIÇÃO
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody Perfil perfil) {
		if (perfilService.buscar(perfil.getId()) != null) {
			perfilRepository.save(perfil);
			return ResponseEntity.ok().body(perfil);
		}

		return new ResponseEntity<>(perfil,HttpStatus.BAD_REQUEST);
	}
	
	// COLSULTA POR CLIENTE
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarPerfilCliente(@PathVariable Integer idCliente) {
		Perfil perfil = perfilService.buscarPorCliente(idCliente);
		if (perfil != null) {
			return ResponseEntity.ok().body(perfil);
		}
		return new ResponseEntity<>(perfil, HttpStatus.NOT_FOUND);
	}
}
