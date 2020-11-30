package com.ms.codify.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.codify.dto.PerfilesDto;
import com.ms.codify.entities.Perfil;
import com.ms.codify.repository.PerfilRepository;

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
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<PerfilesDto> listarPerfiles() {
		log.info("[listarPerfiles]::inicio de metodo");
		List<PerfilesDto> result = new ArrayList<>();
		List<Perfil> perfiles = perfilRepository.findAll();
		for (Perfil perfil : perfiles) {
			result.add(mapper.map(perfil, PerfilesDto.class));
		}
		log.info("[listarPerfiles]::fin de metodo");
		return result;
	}

}
