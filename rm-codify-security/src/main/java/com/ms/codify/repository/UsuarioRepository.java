package com.ms.codify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.codify.entities.Usuario;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByRutOrEmail(String rut, String email);
	
	Long countByRutOrEmail(String rut, String email);
	
}
