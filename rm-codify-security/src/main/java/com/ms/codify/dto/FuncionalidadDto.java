package com.ms.codify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * LoginResponseDto - Response - Spring Boot
 *
 * @author Jesus Garcia
 * @version jdk-11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FuncionalidadDto {

	@JsonProperty
	private Long idFuncionalidad;
	
	@JsonProperty
	private String nombreFuncionalidad;
	
	@JsonProperty
	private boolean lectura;
	
	@JsonProperty
	private boolean escritura;

	public FuncionalidadDto(Long idFuncionalidad, String nombreFuncionalidad, boolean lectura, boolean escritura) {
		super();
		this.idFuncionalidad = idFuncionalidad;
		this.nombreFuncionalidad = nombreFuncionalidad;
		this.lectura = lectura;
		this.escritura = escritura;
	}
	
	
	
}
