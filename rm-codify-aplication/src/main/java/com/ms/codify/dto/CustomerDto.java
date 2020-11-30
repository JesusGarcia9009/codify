package com.ms.codify.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CustomerDto (data access object) - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public class CustomerDto {

    private final Long id;

    private final String name;

    @JsonCreator
    public CustomerDto(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

	public String getName() {
		return name;
	}

    
}