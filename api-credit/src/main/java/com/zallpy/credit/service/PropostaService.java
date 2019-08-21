package com.zallpy.credit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zallpy.credit.model.Cliente;
import com.zallpy.credit.model.Proposta;
import com.zallpy.credit.model.enums.PropostaSituacao;
import com.zallpy.credit.model.enums.SituacaoMotivo;
import com.zallpy.credit.repository.PropostaRepository;
import com.zallpy.credit.service.exceptions.ObjectNotFoundException;

@Service
public class PropostaService {

	/**
	 * Author: Damianos Sotirakis Service: Proposta
	 */

	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private PerfilService perfilService;


	public Proposta buscar(Integer id) {
		Optional<Proposta> proposta = propostaRepository.findById(id);
		return proposta.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado id: " + id + " Tipo: " + Proposta.class.getName()));
	}


	public void avaliacaoRisco(Cliente clienteComPerfil) {
		Proposta proposta = new Proposta();
		proposta.setCliente(clienteComPerfil);
		
		if(perfilService.getCpfSituacao() == 10) {
			proposta.setSituacao(PropostaSituacao.RECUSADO.getValue());
			proposta.setMotivo(SituacaoMotivo.RECUSADO3.getValue());
		}else if(clienteComPerfil.getRenda() <= 800) {
			proposta.setSituacao(PropostaSituacao.RECUSADO.getValue());
			proposta.setMotivo(SituacaoMotivo.RECUSADO2.getValue());
		}else if(clienteComPerfil.getPerfil().getRisco() <= 3.5) {
			proposta.setSituacao(PropostaSituacao.APROVADO.getValue());
			proposta.setMotivo(SituacaoMotivo.APROVADO2.getValue());
		}else if(clienteComPerfil.getPerfil().getRisco() <= 3.5 && clienteComPerfil.getPerfil().getRisco() <= 5) {
			proposta.setSituacao(PropostaSituacao.APROVADO.getValue());
			proposta.setMotivo(SituacaoMotivo.APROVADO1.getValue());
		}else if(clienteComPerfil.getPerfil().getRisco() > 5 && clienteComPerfil.getPerfil().getRisco() <= 6.5) {
			proposta.setSituacao(PropostaSituacao.APROVADO.getValue());
			proposta.setMotivo(SituacaoMotivo.APROVADO1.getValue());
		}else if(clienteComPerfil.getPerfil().getRisco() > 6.5 && clienteComPerfil.getPerfil().getRisco() <= 10) {
			proposta.setSituacao(PropostaSituacao.RECUSADO.getValue());
			proposta.setMotivo(SituacaoMotivo.RECUSADO1.getValue());
		}
		propostaRepository.save(proposta);
	}

	public Proposta buscarPorCliente(Integer idCliente) {
		Proposta proposta = propostaRepository.findPropostaByCliente(idCliente);		
		return proposta;
	}

}
