package com.ms.codify.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserProfile - Hibernate 5.2
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
@Entity
@Table(name = "user_profile", catalog = "codify_security")
public class UserProfile implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides(
			{   @AttributeOverride(name = "idUser", column = @Column(name = "id_user", nullable = false, length = 50)),
				@AttributeOverride(name = "idProfile", column = @Column(name = "id_profile", nullable = false)) })
	private UserProfileId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profile", nullable = false, insertable = false, updatable = false)
	private Profile profile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false, insertable = false, updatable = false)
	private User user;
	
	@Column(name = "id_object", nullable = false, length = 50)
	private String idObject;

	public UserProfile() {
	}

	public UserProfileId getId() {
		return id;
	}

	public void setId(UserProfileId id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIdObject() {
		return idObject;
	}

	public void setIdObject(String idObject) {
		this.idObject = idObject;
	}

	
}
