package com.ms.codify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ms.codify.entities.Permit;
import com.ms.codify.entities.Profile;
import com.ms.codify.token.PermitDto;

/**
 * IPermitRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
public interface IPermitRepository extends CrudRepository<Permit, Long> {

	
	@Query("SELECT new com.ms.codify.token.PermitDto(p.id, p.description) "
			+ "FROM Permit p inner join p.profiles pro WHERE pro in (:profiles)")
	List<PermitDto> getPermitsByProfiles(@Param("profiles") List<Profile> profiles);
	
}
