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
public class StateDto {
	
	@JsonProperty
	@NotNull(message = "Es obligatorio")
	private Long id;
	
	@NotBlank(message = "Es obligatorio")
	private String name;
	
}
