package com.ms.codify.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.codify.dto.ProfileResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * ProfileController - Capa de Rest - Profiles services - Spring Boot
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
@Api(value = "Profiles services", description = "This API has the services referring to operations associated with the profiles")
public interface ProfileController {


	/**
	 * Profile List All - method to list the existing profiles in the system
	 *
	 * @author DutyMachine
	 * @version jdk-11
	 * @param none
	 * @return List<ProfileResponseDto> see ProfileResponseDto Profile response object
	 */
	@ApiOperation(value = "Get Profiles", notes = "Method to list the existing profiles in the system")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful return")})
	public ResponseEntity<List<ProfileResponseDto>> getAllProfiles() ;
	
}
