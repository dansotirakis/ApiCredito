package com.zallpy.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.credit.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

	Object findByRisco(Integer risco);

	/**
	 * Author: Damianos Sotirakis Repository: Perfil
	 */
	
}
