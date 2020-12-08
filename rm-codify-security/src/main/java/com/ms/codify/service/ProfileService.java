package com.ms.codify.service;

import java.util.List;

import com.ms.codify.dto.ProfileResponseDto;


/**
 * UsersService servicio de usuario
 * 
 * @author DutyMachine
 * @version 1.0 Creacion
 * @since Java 11
 */
public interface ProfileService {

	
	/**
	 * get list of profiles
	 * 
	 * @param none
	 * @return model @see User
	 */
	public List<ProfileResponseDto> getAll(); 
	
}
