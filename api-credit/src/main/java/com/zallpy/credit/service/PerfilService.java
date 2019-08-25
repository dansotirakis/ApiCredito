package com.zallpy.credit.service;

import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zallpy.credit.fuzzy.Aircon;
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

	/**
	 * Implementar consulta situação cadastral cpf.. (Paga!)
	 */
	
	String situacao = "r";
	Integer cadSituacao = 10;
	

	public Integer getCpfSituacao() {
		return cadSituacao;
	}

	public void setCpfSituacao(Integer cadSituacao) {
		this.cadSituacao = cadSituacao;
	}

	public Perfil buscar(Integer id) {
		Optional<Perfil> perfil = perfilRepository.findById(id);
		return perfil.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado id: " + id + " Tipo: " + Perfil.class.getName()));
	}
	
	public Perfil buscarPorCliente(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		Perfil perfil = cliente.get().getPerfil();
		return perfil;
	}
	
	public Cliente avaliacaoPerfil(Cliente cliente) throws URISyntaxException {
				
		if (situacao.equals("r")){
			cadSituacao = 0;
		}		
		
		double z = 0; //cpf
	    double a = 0; //idade
	    double l = 0; //estadoCivil
	    double p = 0; //uf
	    double t = 0; //renda
	    double s = 0; //dependentes
	    
		//CPF
		int cadSituacao = 10;
		switch (cadSituacao){
        case 0:
            z = 0;
            break;
        case 10:
            z = 10;
            break;
		}
		//IDADE
		if(cliente.getIdade() > 16 && cliente.getIdade() < 21) {
			a = 3.3;
			//Primeira
		}
		else if(cliente.getIdade() > 21 && cliente.getIdade() < 42) {
			a = 6.6;
		}	//Segunda
		else if(cliente.getIdade() > 42 && cliente.getIdade() < 80) {
			a = 10;
			//Terceira
		}
		//ESTADOCIVIL
		if (cliente.getEstadocivil() == 1){
			l = 3.5;
        	//solteiro
		}
		else if (cliente.getEstadocivil() == 2){
            l = 5;
            //casado
		}
		else if (cliente.getEstadocivil() == 3){
	        l = 6.5;
	        //viuvo
		}
		else if (cliente.getEstadocivil() == 4){
	        l = 10;
	        //divorciado
		}
	
		//UF
		if (cliente.getUf().equals("PA")
				||cliente.getUf().equals("AM")
				||cliente.getUf().equals("RR")
				||cliente.getUf().equals("AP")
				||cliente.getUf().equals("TO")
				||cliente.getUf().equals("RO")
				||cliente.getUf().equals("AC")
				||cliente.getUf().equals("MA")
				
				){
			p = 3.5;
		}else if (cliente.getUf().equals("PI")
				||cliente.getUf().equals("CE")
				||cliente.getUf().equals("RN")
				||cliente.getUf().equals("PE")
				||cliente.getUf().equals("PB")
				||cliente.getUf().equals("SE")
				||cliente.getUf().equals("AL")
				||cliente.getUf().equals("BA")
				){
			p = 5;
		}else if (cliente.getUf().equals("MT")
				||cliente.getUf().equals("MS")
				||cliente.getUf().equals("GO")
				||cliente.getUf().equals("SP")
				||cliente.getUf().equals("RJ")
				||cliente.getUf().equals("ES")
				||cliente.getUf().equals("MG")
				){
			p = 6.5;
		}else if (cliente.getUf().equals("PR")
				||cliente.getUf().equals("RS")
				||cliente.getUf().equals("SC")
				||cliente.getUf().equals("SP")
				||cliente.getUf().equals("RJ")
				||cliente.getUf().equals("ES")
				||cliente.getUf().equals("MG")){
			p = 10;
		}
		
		//RENDA
		if (cliente.getRenda() < 1200){
			t = 3.5;
		}else if (cliente.getRenda() < 2400){
			t = 5;
		}else if (cliente.getRenda() >= 2400 && cliente.getRenda() < 3600){
			t = 6.5;
		}else if (cliente.getRenda() >= 3600){
			t = 10;
		}
		//DEPENDENTES
		if (cliente.getDependerntes() == 1){
			s = 3.5;
		}else if (cliente.getDependerntes() == 2){
			s = 5;
		}else if (cliente.getDependerntes() == 3){
			s = 6.5;
		}else if (cliente.getDependerntes() >= 4){
			s = 10;
		}
		
		//Avaliação de risco com Fuzzy
		Aircon aircon=new Aircon(z,a,l,p,t,s);
        //JFuzzyChart.chart(aircon.getModel());
        Integer risco = Integer.valueOf(aircon.toString());
        Perfil perfil = new Perfil();

        perfil.setRisco(risco);
        
        Perfil perfilSelecionado = new Perfil();
		
        //Atrbuição de alçada a partir do risco
		if(perfil.getRisco() <= 3.5) {
			
			 perfilSelecionado = perfilRepository.getOne(1);
			
		}else if(perfil.getRisco() > 3.5  && perfil.getRisco() <= 5) {
			
			perfilSelecionado = perfilRepository.getOne(2);
			
		}else if(perfil.getRisco() > 5 && perfil.getRisco() <= 6.5) {
			
			perfilSelecionado = perfilRepository.getOne(3);
			
		}else if(perfil.getRisco() > 6.5 && perfil.getRisco() <= 10) {
			
			perfilSelecionado = perfilRepository.getOne(4);
			
		}
		
		cliente.setPerfil(perfilSelecionado);
		
		return cliente;
	}

	public boolean existe(Perfil perfil) {
		Boolean c = false;
		if(perfilRepository.findByRisco(perfil.getRisco()) != null) {
			c = true;
		}
		return c;
	}
	
}
