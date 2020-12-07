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
	
	/**
	 * Obtiene un perfil asociado a un id
	 * 
	 * @param dto
	 * @return PerfilesDto
	 */
	public PerfilesDto obtenerPerfil(Long idPerfil); 
	
	/**
	 * Guardar datos modificados del perfil
	 * 
	 * @param Long idPerfil
	 * @return PerfilesDto
	 */
	public PerfilesDto guardarPerfil(PerfilesDto perfil); 
	
	/**
	 * Eliminar los datos del perfil
	 * 
	 * @param Long idPerfil
	 * @return PerfilesDto
	 */
	public void eliminarPerfil(Long idPerfil); 
	
	
}
