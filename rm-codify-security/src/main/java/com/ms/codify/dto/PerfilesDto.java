package com.ms.codify.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * PerfilesDto - Response - Spring Boot
 *
 * @author Jesus Garcia
 * @version jdk-11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PerfilesDto {
	
	@JsonProperty
    private Long idPerfil;
 
	@JsonProperty
    private String nombre;
    
	@JsonProperty
    private String descripcion;
	
	@JsonProperty
	private List<FuncionalidadDto> funcionalidadList = new ArrayList<>();

}
