package com.ms.codify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * LoginResponseDto - Response - Spring Boot
 *
 * @author DutyMachine
 * @version jdk-11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthResponseDto {
	
	@JsonProperty
	private String username;
	
	@JsonProperty
	private String fullName;
	
	@JsonProperty
	private String token;

}
