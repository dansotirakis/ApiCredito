package com.zallpy.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.credit.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer> {

	/**
	 * Author: Damianos Sotirakis Repository: Proposta
	 */

}
