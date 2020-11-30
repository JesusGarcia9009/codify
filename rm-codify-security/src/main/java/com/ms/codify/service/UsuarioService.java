package com.ms.codify.service;

import com.ms.codify.dto.RegistrarRequestDto;
import com.ms.codify.entities.Usuario;


/**
 * UsersService servicio de usuario
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
public interface UsuarioService {

	
	/**
	 * Obtiene el Dto de lo usuarios
	 * 
	 * @param dto
	 * @return
	 */
	public Usuario buscarUsers(Long id); 
	
	/**
	 * Obtiene el el modelo by username o rut
	 * 
	 * @param string userNameOrRut
	 * @return model @see UsersModel
	 */
	public Usuario buscarUsuarioByEmailOrRut(String emailOrRut); 
	
	/**
	 * Cuenta que exista el usuario por rut o urname
	 * 
	 * @param string userNameOrRut
	 * @return model @see UsersModel
	 */
	public Long countUsuarioByEmailOrRut(String emailOrRut) ;
	
	/**
	 * Registrar Usuario en la plataforma
	 * 
	 * @param string userNameOrRut
	 * @return model @see UsersModel
	 */
	public boolean registrarUsuario(RegistrarRequestDto dto);
}
