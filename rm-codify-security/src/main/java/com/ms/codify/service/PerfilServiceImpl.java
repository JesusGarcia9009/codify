package com.ms.codify.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.codify.dto.PerfilesDto;
import com.ms.codify.entities.Perfil;
import com.ms.codify.entities.PerfilFuncionalidad;
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
		List<Perfil> perfiles = perfilRepository.getAllPerfiles();
		for (Perfil perfil : perfiles) {
			List<PerfilFuncionalidad> perfilFuncionalidadList = perfil.getPerfilFuncionalidadList();
			for (PerfilFuncionalidad fun : perfilFuncionalidadList) {
				PerfilFuncionalidad f = fun;
				Long x = f.getIdUsuarioPerfil();
			}
			result.add(mapper.map(perfil, PerfilesDto.class));
			
		}
		log.info("[listarPerfiles]::fin de metodo");
		return result;
	}

	@Override
	public PerfilesDto obtenerPerfil(Long idPerfil) {
		log.info("[obtenerPerfil]::inicio de metodo");
		PerfilesDto resultado = null;
		Optional<Perfil> perfil = perfilRepository.findById(idPerfil);
		if (perfil.isPresent())
			resultado = mapper.map(perfil, PerfilesDto.class);
		log.info("[obtenerPerfil]::fin de metodo");
		return resultado;
	}

	@Override
	public PerfilesDto guardarPerfil(PerfilesDto dto) {
		log.info("[obtenerPerfil]::inicio de metodo");
		Perfil model = new Perfil();
		if (dto.getIdPerfil() != null) {
			Optional<Perfil> opt = perfilRepository.findById(dto.getIdPerfil());
			if (opt.isPresent())
				model = opt.get();
		}
		model = new Perfil();
		model.setNombre(dto.getNombre());
		model.setDescripcion(dto.getDescripcion());
		
		perfilRepository.save(model);
		log.info("[obtenerPerfil]::fin de metodo");
		return mapper.map(model, PerfilesDto.class);
	}

	@Override
	public void eliminarPerfil(Long idPerfil) {
		log.info("[eliminarPerfil]::inicio de metodo");
		perfilRepository.deleteById(idPerfil);
		log.info("[eliminarPerfil]::fin de metodo");
	}

}
