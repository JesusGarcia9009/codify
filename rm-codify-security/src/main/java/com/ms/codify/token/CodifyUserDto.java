package com.ms.codify.token;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * CodifyUserDto - Usuario del token - Spring Boot
 *
 * @author DutyMachine
 * @since 1.0
 * @version jdk-11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CodifyUserDto implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;

	private String fullName;
	
	private String email;
	
	private String languaje;
	
	private String password;
	
	private List<PermitDto> permits;
	
    private Collection<? extends GrantedAuthority> authorities;
    
    
    @Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
