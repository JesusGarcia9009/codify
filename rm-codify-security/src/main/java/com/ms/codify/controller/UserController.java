package com.ms.codify.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.codify.dto.RegisterRequestDto;
import com.ms.codify.dto.UserResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * LoginUserController - Capa de Rest - Servicio de login - Spring Boot
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
@Api(value = "System Users Service", description = "This API has the services referring to operations with users of the system")
public interface UserController {


	/**
	 * User registration Method in charge of creating user data in addition to roles, permissions and languaje.- Spring Boot
	 *
	 * @author DutyMachine
	 * @version jdk-11
	 * @param dto RegisterRequestDto.class registration request object
	 * @return ResponseEntity<?> registration response
	 */
	@ApiOperation(value = "Register User", notes = "Method to register user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return")})
	public ResponseEntity<?> registerUser(RegisterRequestDto dto);
	
	/**
	 * User List All - method to list the existing users in the system - Spring Boot
	 *
	 * @author DutyMachine
	 * @version jdk-11
	 * @param none
	 * @return ResponseEntity<List<UserResponseDto>> getAllUsers response
	 */
	@ApiOperation(value = "Get Users", notes = "Method to list the existing users in the system")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return")})
	public ResponseEntity<List<UserResponseDto>> getAllUsers();
	
}
