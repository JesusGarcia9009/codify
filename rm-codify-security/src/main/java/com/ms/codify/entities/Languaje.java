package com.ms.codify.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Languaje - Hibernate 5.2
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
@Entity
@Table(name = "languaje", catalog = "codify_security")
public class Languaje implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "code", unique = true, nullable = false, length = 2)
	private String code;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "languaje")
	private Set<User> users = new HashSet<>(0);

	public Languaje() {}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	

}
