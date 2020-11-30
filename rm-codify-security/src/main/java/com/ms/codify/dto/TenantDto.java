package com.ms.codify.dto;

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
public class TenantDto {
	
	@JsonProperty
	public Long idTenant;

	@JsonProperty
	public String nombre;

	@JsonProperty
	public String llave;

}
