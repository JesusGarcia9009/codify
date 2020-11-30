package com.ms.codify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.codify.entities.Tenant;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

	
	
}
