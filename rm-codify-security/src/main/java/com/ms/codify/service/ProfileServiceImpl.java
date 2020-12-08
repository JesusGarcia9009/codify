package com.ms.codify.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.codify.dto.ProfileResponseDto;
import com.ms.codify.repository.IProfileRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * UsersServiceImpl class that implements the service interface
 * 
 * @author DutyMachine
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private IProfileRepository profileRepository;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<ProfileResponseDto> getAll() {
		log.info("[getAll]::start of method");
		List<ProfileResponseDto> list = new ArrayList<>();
		profileRepository.findAll().forEach(x -> list.add(mapper.map(x, ProfileResponseDto.class)));
		log.info("[getAll]::end of method");
		return list;
	}
	
	
}
