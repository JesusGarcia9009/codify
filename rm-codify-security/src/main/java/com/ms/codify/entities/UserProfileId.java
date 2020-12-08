package com.ms.codify.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserProfileId - Hibernate 5.2
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
@Embeddable
public class UserProfileId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_user", nullable = false, length = 50)
	private String idUser;
	
	@Column(name = "id_profile", nullable = false)
	private long idProfile;

	public UserProfileId() {
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public long getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(long idProfile) {
		this.idProfile = idProfile;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserProfileId))
			return false;
		UserProfileId castOther = (UserProfileId) other;

		return ((this.getIdUser() == castOther.getIdUser()) || (this.getIdUser() != null
				&& castOther.getIdUser() != null && this.getIdUser().equals(castOther.getIdUser())))
				&& (this.getIdProfile() == castOther.getIdProfile());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdUser() == null ? 0 : this.getIdUser().hashCode());
		result = 37 * result + (int) this.getIdProfile();
		return result;
	}

}
