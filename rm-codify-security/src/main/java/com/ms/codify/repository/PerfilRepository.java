package com.ms.codify.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.codify.entities.Perfil;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
	
	@Query("SELECT p FROM Perfil p join fetch p.perfilFuncionalidadList ")
	List<Perfil> getAllPerfiles();

	@Query("SELECT u.perfil FROM Usuario u fetch all properties WHERE u.idUsuario=:idUsuario")
	Set<Perfil> findPerfilesByUserId(@Param("idUsuario") Long idUsuario);
	
}
