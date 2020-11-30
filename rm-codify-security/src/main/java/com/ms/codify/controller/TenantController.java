package com.ms.codify.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.codify.dto.TenantDto;
import com.ms.codify.exception.DataNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * TenantController - Capa de Rest - Servicio de tenants - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Api(value = "Microservicio de tenants de sistema", description = "Esta API tiene los servicios referentes a operaciones con tenants")
public interface TenantController {


	/**
	 * listarPerfiles - Metodo encargado listar todos los tenants de la aplciacion. - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @version jdk-11
	 * @param none
	 * @return ResponseEntity<TenantDto> see TenantDto objeto respuesta del listado de tenants
	 */
	@ApiOperation(value = "listar tenants", notes = "Retorna los datos asociados a los tenants de la aplicacion Codify")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
	public ResponseEntity<List<TenantDto>> listarPerfiles() throws DataNotFoundException ;
	
}
