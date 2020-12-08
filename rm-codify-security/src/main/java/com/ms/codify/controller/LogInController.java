package com.ms.codify.controller;

import org.springframework.http.ResponseEntity;

import com.ms.codify.dto.UserAuthRequestDto;
import com.ms.codify.dto.UserAuthResponseDto;
import com.ms.codify.exception.UserNotAuthException;

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
@Api(value = "Authentication Services", description = "This API has the services referring to authentication operations")
public interface LogInController {


	/**
	 * User Authentication - Method in charge of creating token with user data in addition to roles, permissions and languaje.- Spring Boot
	 *
	 * @author DutyMachine
	 * @version jdk-11
	 * @param dto UserAuthRequestDTO.class authentication request object
	 * @return ResponseEntity<UserAuthResponseDTO> see UserAuthResponseDTO authentication response object
	 */
	@ApiOperation(value = "Authenticate", notes = "Returns the data of the connection api to our application")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return")})
	public ResponseEntity<UserAuthResponseDto> authUser(UserAuthRequestDto dto) throws UserNotAuthException ;
	
	
}
