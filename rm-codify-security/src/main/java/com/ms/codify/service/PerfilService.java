package com.ms.codify.service;

import java.util.List;

import com.ms.codify.dto.PerfilesDto;


/**
 * PerfilService servicio de perfiles
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
public interface PerfilService {

	
	/**
	 * Obtiene el listado Dto de los perfiles
	 * 
	 * @param dto
	 * @return
	 */
	public List<PerfilesDto> listarPerfiles(); 
	
	
}
