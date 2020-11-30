package com.ms.codify.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * LoginRequestDto - Request - Spring Boot
 *
 * @author Jesus Garcia
 * @version jdk-11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegistrarRequestDto {

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	public String rut;

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	public String nombre;

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	public String apellidoPaterno;

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	public String apellidoMaterno;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	public String email;

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	public String pass;
	
	@JsonProperty
	@NotNull(message = "Es obligatorio")
	public Long idTenant;
	
	@JsonProperty
	@NotNull(message = "Es obligatorio")
	private List<Long> perfiles;
}
