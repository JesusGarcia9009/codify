package com.ms.codify.security;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * PerfilesDto - Response - Spring Boot
 *
 * @author DutyMachine
 * @version jdk-11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PermitDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
    private Long id;
    
	@JsonProperty
    private String description;

	public PermitDto(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	

}
