package com.ms.codify.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.dto.UserAuthRequestDto;
import com.ms.codify.dto.UserAuthResponseDto;
import com.ms.codify.exception.UserNotAuthException;
import com.ms.codify.service.UserService;
import com.ms.codify.token.CodifyUserDto;
import com.ms.codify.token.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${api.codify.base.uri}")
@Slf4j
public class LogInControllerImpl implements LogInController {

	@Autowired
	public JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	public UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<UserAuthResponseDto> authUser(@Valid @RequestBody UserAuthRequestDto dto) throws UserNotAuthException{
		log.info("[authUser] :: method start" );
		Authentication sigin = null;
		sigin = jwtTokenUtil.createToken(dto.getUsername(), dto.getPassword());
		
		UserAuthResponseDto autPass = new UserAuthResponseDto();
		CodifyUserDto user = (CodifyUserDto) sigin.getPrincipal();
		
		autPass.setToken(jwtTokenUtil.generateToken(sigin));
		autPass.setUsername(user.getUsername());
		autPass.setFullName(user.getFullName());
		log.info("[authUser] :: method end" );
		return new ResponseEntity<>(autPass, HttpStatus.OK);
	}
	
}
