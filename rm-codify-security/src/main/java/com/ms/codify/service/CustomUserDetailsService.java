package com.ms.codify.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ms.codify.dto.CodifyUserDto;
import com.ms.codify.entities.Perfil;
import com.ms.codify.entities.Usuario;
import com.ms.codify.repository.PerfilFuncionalidadRepository;
import com.ms.codify.repository.PerfilRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomUserDetailsService servicio de usuario para Sprint Security
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService usersService;

	@Autowired
	private PerfilRepository profile;
	
	@Autowired
	private PerfilFuncionalidadRepository funcionalidad;
	
	@Override
	public CodifyUserDto loadUserByUsername(String emailOrRut) throws UsernameNotFoundException {
		log.info("[loadUserByUsername]::inicio de metodo");
		Usuario user = null;

		user = usersService.buscarUsuarioByEmailOrRut(emailOrRut);

		if (user == null) {
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
	private CodifyUserDto createUserCodify(Usuario usuarioModel) {
		log.info("[createUserCodify]::inicio de metodo");
		CodifyUserDto codifyUser = new CodifyUserDto();

		codifyUser.setIdUsuario(usuarioModel.getIdUsuario());
		codifyUser.setFullName(usuarioModel.getNombre() + " " + usuarioModel.getApellidoPaterno());
		codifyUser.setUsername(usuarioModel.getEmail());
		codifyUser.setRut(usuarioModel.getRut());
		codifyUser.setPassword(usuarioModel.getPass());
		codifyUser.setEmail(usuarioModel.getEmail());
		codifyUser.setIdTenant(usuarioModel.getTenant().getLlave());

		Set<Perfil> list = profile.findPerfilesByUserId(usuarioModel.getIdUsuario());
		codifyUser.setFuncionalidades(funcionalidad.findFuncionalidadesByPerfiles(list));

		if (!list.isEmpty()) {
			List<GrantedAuthority> authorities = list.stream()
					.map(permiso -> new SimpleGrantedAuthority(permiso.getNombre())).collect(Collectors.toList());
			codifyUser.setAuthorities(authorities);
		}

		log.info("[createUserCodify]::fin de metodo");
		return codifyUser;
	}

}