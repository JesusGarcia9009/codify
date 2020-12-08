package com.ms.codify.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ms.codify.entities.User;
import com.ms.codify.repository.IPermitRepository;
import com.ms.codify.token.CodifyUserDto;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomUserDetailsService servicio de usuario para Sprint Security
 * 
 * @author DutyMachine
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService usersService;

	@Autowired
	private IPermitRepository permitRepository;

	@Override
	public CodifyUserDto loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("[loadUserByUsername]::inicio de metodo");
		User user = null;
		if (usersService.countUserByUsername(username) > 0) {
			user = usersService.getUserByUsername(username);
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		log.info("[loadUserByUsername]::fin de metodo");
		return createUserCodify(user);
	}

	/**
	 * Genera el Usuario a guardar en el token con toda su informacion y permisos
	 * asociados
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	private CodifyUserDto createUserCodify(User user) {
		log.info("[createUserCodify]::inicio de metodo");
		CodifyUserDto codifyUser = new CodifyUserDto();

		codifyUser.setEmail(user.getEmail());
		codifyUser.setFullName(user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName());
		codifyUser.setUsername(user.getUsername());
		codifyUser.setPassword(user.getPassword());
		codifyUser.setLanguaje(user.getLanguaje().getCode());

		codifyUser.setPermits(permitRepository.getPermitsByProfiles(user.getUserProfiles().stream().map(up -> up.getProfile()).collect(Collectors.toList())));
		List<GrantedAuthority> authorities = user.getUserProfiles().stream().map(userprofile -> new SimpleGrantedAuthority(userprofile.getProfile().getName())).collect(Collectors.toList());
		codifyUser.setAuthorities(authorities);

		log.info("[createUserCodify]::fin de metodo");
		return codifyUser;
	}

}