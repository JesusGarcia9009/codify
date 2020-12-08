package com.ms.codify.service;

import java.util.List;

import com.ms.codify.dto.RegisterRequestDto;
import com.ms.codify.dto.UserResponseDto;
import com.ms.codify.entities.User;


/**
 * UsersService servicio de usuario
 * 
 * @author DutyMachine
 * @version 1.0 Creacion
 * @since Java 11
 */
public interface UserService {

	
	/**
	 * get user by field username
	 * 
	 * @param string username
	 * @return model @see User
	 */
	public User getUserByUsername(String username); 
	
	/**
	 * count users with username
	 * 
	 * @param string userNameOrRut
	 * @return Long - count number of users
	 */
	public Long countUserByUsername(String username) ;
	
	/**
	 * Register User
	 * 
	 * @param Object see RegisterRequestDto
	 * @return boolean var
	 */
	public boolean userRegister(RegisterRequestDto dto);
	
	/**
	 * get All User
	 * 
	 * @param none
	 * @return List<UserResponseDto> @see UserResponseDto
	 */
	public List<UserResponseDto> getAllUsers();
	
	
}
