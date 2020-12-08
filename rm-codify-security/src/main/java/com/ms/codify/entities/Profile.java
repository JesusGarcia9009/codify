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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Profile - Hibernate 5.2
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
@Entity
@Table(name = "profile", catalog = "codify_security")
public class Profile implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 500)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
	private Set<UserProfile> userProfiles = new HashSet<>(0);
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "profile_permit", 
				catalog = "codify_security", 
				joinColumns = { @JoinColumn(name = "id_profile", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "id_permit", nullable = false, updatable = false) })
	private Set<Permit> permits = new HashSet<>(0);

	public Profile() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public Set<Permit> getPermits() {
		return permits;
	}

	public void setPermits(Set<Permit> permits) {
		this.permits = permits;
	}

}
