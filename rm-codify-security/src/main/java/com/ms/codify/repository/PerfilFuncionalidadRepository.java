package com.ms.codify.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.codify.dto.FuncionalidadDto;
import com.ms.codify.entities.Perfil;
import com.ms.codify.entities.PerfilFuncionalidad;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface PerfilFuncionalidadRepository extends JpaRepository<PerfilFuncionalidad, Long> {

	@Query("SELECT new com.ms.codify.dto.FuncionalidadDto(f.idFuncionalidad, f.nombre, pf.lectura, pf.escritura) "
			+ "FROM PerfilFuncionalidad pf inner join pf.funcionalidad f WHERE pf.perfil in (:perfiles)")
	List<FuncionalidadDto> findFuncionalidadesByPerfiles(@Param("perfiles") Set<Perfil> perfiles);
	
}
