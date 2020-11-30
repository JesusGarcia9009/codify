package com.ms.codify.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.ms.codify.dto.CustomerDto;

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
@Api(value = "Microservicio de cliente", description = "Esta API tiene los servicios referentes a operaciones de los clientes")
public interface CustomerController {


	/**
	 * getAll - Metodo listar clientes de los distintos tenant. - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @version jdk-11
	 * @param none
	 * @return ResponseEntity<CustomerDto> see CustomerDto objeto respuesta de listado de clientes
	 */
	@ApiOperation(value = "listar clientes", notes = "Retorna los datos de clientes asociados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public List<CustomerDto> getAll();

	/**
	 * autenticacionUsuario - Metodo obtener un cliente. - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @version jdk-11
	 * @param none
	 * @return ResponseEntity<CustomerDto> see CustomerDto clientes
	 */
	@ApiOperation(value = "listarPerfiles", notes = "Retorna el cliente asiciado al id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public CustomerDto get(long id);

	/**
	 * autenticacionUsuario - Metodo encargado listar los perfiles del sistema. - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @version jdk-11
	 * @param none
	 * @return ResponseEntity<CustomerDto> 
	 */
	@ApiOperation(value = "Listar clientes", notes = "Retorna los datos de los clientes asincronamente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public List<CustomerDto> getAllAsync() throws ExecutionException, InterruptedException ;

	/**
	 * autenticacionUsuario - Metodo encargado listar los perfiles del sistema. - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @version jdk-11
	 * @param none
	 * @return CustomerDto
	 */
	@ApiOperation(value = "Guardar cliente", notes = "Retorna guardar cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public CustomerDto post(CustomerDto customer);

	/**
	 * autenticacionUsuario - delete customer. - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @version jdk-11
	 * @param none
	 * @return void
	 */
	@ApiOperation(value = "Eliminar cliente", notes = "Elimina clientes de la palicacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public void delete(long id) ;
	
}
