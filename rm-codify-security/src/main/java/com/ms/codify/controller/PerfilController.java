package com.ms.codify.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.codify.dto.PerfilesDto;
import com.ms.codify.exception.DataNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * LoginUserController - Capa de Rest - Servicio de perfiles - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Api(value = "Microservicio de perfiles de sistema", description = "Esta API tiene los servicios referentes a operaciones con perfiles")
public interface PerfilController {


	/**
	 * autenticacionUsuario - Metodo encargado listar los perfiles del sistema. - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @version jdk-11
	 * @param none
	 * @return ResponseEntity<PerfilesDto> see PerfilesDto objeto respuesta de listado de perfiles
	 */
	@ApiOperation(value = "listarPerfiles", notes = "Retorna los datos de perfiles de la aplicacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
	public ResponseEntity<List<PerfilesDto>> listarPerfiles() throws DataNotFoundException ;
	
}
