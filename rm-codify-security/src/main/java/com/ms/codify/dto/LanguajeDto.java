package com.ms.codify.dto;

import javax.validation.constraints.NotBlank;

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
public class LanguajeDto {
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String code;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String name;
	
	
	
}
