package com.ms.codify.service;

import java.util.List;

import com.ms.codify.dto.TenantDto;


/**
 * TenantService servicio para la gestion de tenant
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
public interface TenantService {

	
	/**
	 * Obtiene el listado Dto de los perfiles
	 * 
	 * @param dto
	 * @return
	 */
	public List<TenantDto> listarTenants(); 
	
	
}
