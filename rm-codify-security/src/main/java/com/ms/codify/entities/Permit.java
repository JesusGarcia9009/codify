package com.ms.codify.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Permit - Hibernate 5.2
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
@Entity
@Table(name = "permit", catalog = "codify_security")
public class Permit implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "description", nullable = false, length = 500)
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "profile_permit", 
				catalog = "codify_security", 
				joinColumns = { @JoinColumn(name = "id_permit", nullable = false, updatable = false) }, 
				inverseJoinColumns = {@JoinColumn(name = "id_profile", nullable = false, updatable = false) })
	private Set<Profile> profiles = new HashSet<>(0);

	public Permit() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}



}
