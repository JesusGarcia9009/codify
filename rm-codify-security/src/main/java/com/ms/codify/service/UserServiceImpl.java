package com.ms.codify.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.codify.dto.LanguajeDto;
import com.ms.codify.dto.RegisterRequestDto;
import com.ms.codify.dto.StateDto;
import com.ms.codify.dto.UserResponseDto;
import com.ms.codify.entities.User;
import com.ms.codify.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * UsersServiceImpl clase que implementa la interfaz de servicio
 * 
 * @author DutyMachine
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@Override
	public User getUserByUsername(String username) {
		log.info("[getUserByUsername]::start/end of method");
		return userRepository.findByUsername(username);
	}

	@Override
	public Long countUserByUsername(String username) {
		log.info("[countUserByUsername]::start/end of method");
		return userRepository.countByUsername(username);
	}

	@Override
	public boolean userRegister(RegisterRequestDto dto) {
		log.info("[UserRegister]::start/end of method");
		return true;
	}

	@Override
	public List<UserResponseDto> getAllUsers() {
		log.info("[getAllUsers]::start of method");
		List<UserResponseDto> list = new ArrayList<>();
		Iterable<User> listado = userRepository.findAllUsers();
		for (User user : listado) {
			UserResponseDto temp = mapper.map(user, UserResponseDto.class);
			temp.setState(mapper.map(user.getState(), StateDto.class));
			temp.setLanguaje(mapper.map(user.getLanguaje(), LanguajeDto.class));
			list.add(temp);
		}
		log.info("[getAllUsers]::end of method");
		return list;
	}
	

	
	

	
}
