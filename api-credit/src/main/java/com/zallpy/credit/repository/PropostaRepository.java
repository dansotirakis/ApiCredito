package com.zallpy.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zallpy.credit.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer> {

	@Query(value = "SELECT * FROM proposta WHERE proposta.cliente_id = ?1",
	nativeQuery = true)
	Proposta findPropostaByCliente(Integer idCliente);

	/**
	 * Author: Damianos Sotirakis Repository: Proposta
	 */

}
