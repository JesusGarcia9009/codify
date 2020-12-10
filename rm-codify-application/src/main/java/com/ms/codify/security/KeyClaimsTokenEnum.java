package com.ms.codify.security;


/**
 * KeyClaimsTokenEnum - Claims_Token - Spring Boot
 *
 * @author DutyMachine
 * @version jdk-11
 */
public enum KeyClaimsTokenEnum {
	
	FULL_NAME("fullName"),
	USERNAME("username"),
	LANGUAJE("language_code"),
	AUTHORITIES("authorities"),
	PERMITS("permits");
	
	
	private String descripcion;
	
	KeyClaimsTokenEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
