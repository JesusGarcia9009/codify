package com.ms.codify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.dto.RegisterRequestDto;
import com.ms.codify.dto.UserResponseDto;
import com.ms.codify.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${api.codify.base.uri}/user")
@Slf4j
public class UserControllerImpl implements UserController {

	@Autowired
	public UserService userService;
	
	@PostMapping("/register")
	@PreAuthorize("hasAuthority('Administrator')")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequestDto dto){
		log.info("[registrarUsuario] :: Inicio/Fin del Metodo" );
		return new ResponseEntity<>(userService.userRegister(dto) , HttpStatus.OK);
	}

	@Override
	@GetMapping("/get-user-list")
	@PreAuthorize("hasAuthority('Administrator')")
	public ResponseEntity<List<UserResponseDto>> getAllUsers() {
		log.info("[getAllProfiles]::start of method");
		List<UserResponseDto> data = userService.getAllUsers();
		log.info("[getAllProfiles]:: end of method");
		return new ResponseEntity<>(data, data.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}
	
}
