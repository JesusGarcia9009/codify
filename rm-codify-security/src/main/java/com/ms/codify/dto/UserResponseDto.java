package com.ms.codify.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * UserResponseDto - Response - Spring Boot dto (data acces object)
 *
 * @author DutyMachine
 * @version jdk-11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String username;
	
	@JsonProperty
	@NotNull(message = "Es obligatorio")
	private LanguajeDto languaje;
	
	@JsonProperty
	@NotNull(message = "Es obligatorio")
	private StateDto state;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String password;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String firstName;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String middleName;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String lastName;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String email;
	
}
