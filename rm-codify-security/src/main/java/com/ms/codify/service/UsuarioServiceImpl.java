package com.ms.codify.service;

import java.util.Optional;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.codify.dto.RegistrarRequestDto;
import com.ms.codify.entities.Perfil;
import com.ms.codify.entities.Tenant;
import com.ms.codify.entities.Usuario;
import com.ms.codify.repository.PerfilRepository;
import com.ms.codify.repository.TenantRepository;
import com.ms.codify.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * UsersServiceImpl clase que implementa la interfaz de servicio
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public Usuario buscarUsers(Long id) {
		log.info("[buscarUsers]::inicio de metodo");
		Optional<Usuario> optional = usuarioRepository.findById(id);
		Usuario result = null;
		if (optional.isPresent())
			result = optional.get();
		else
			result = null;
		log.info("[buscarUsers]::fin de metodo");
		return result;
	}

	@Override
	public Usuario buscarUsuarioByEmailOrRut(String emailOrRut) {
		log.info("[buscarUserByNameOrRut]::inicio de metodo");
		Usuario resultado = null;
		resultado = usuarioRepository.findByRutOrEmail(emailOrRut, emailOrRut);
		Optional<Tenant> tennant = tenantRepository.findById(resultado.getTenant().getIdTenant());
		resultado.setTenant(tennant.get());

		log.info("[buscarUserByNameOrRut]::fin de metodo");
		return resultado;
	}

	@Override
	public Long countUsuarioByEmailOrRut(String emailOrRut) {
		log.info("[countUserByNameOrRut]::inicio de metodo");
		Long resultado = null;
		resultado = usuarioRepository.countByRutOrEmail(emailOrRut, emailOrRut);

		log.info("[countUserByNameOrRut]::fin de metodo");
		return resultado;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public boolean registrarUsuario(RegistrarRequestDto dto) {
		log.info("[registrarUsuario]::inicio de metodo");
		Usuario user = mapper.map(dto, Usuario.class);
		Set<Perfil> perfiles = (Set<Perfil>) perfilRepository.findAllById(dto.getPerfiles());
		user.setPerfil(perfiles);
		user.setTenant(tenantRepository.getOne(dto.getIdTenant()));
		usuarioRepository.save(user);
		log.info("[registrarUsuario]::fin de metodo");
		return true;
	}

}
