package com.ms.codify.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.dto.CodifyUserDto;
import com.ms.codify.dto.LoginRequestDto;
import com.ms.codify.dto.LoginResponseDto;
import com.ms.codify.dto.RegistrarRequestDto;
import com.ms.codify.exception.UserNotAuthException;
import com.ms.codify.service.UsuarioService;
import com.ms.codify.utils.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${api.codify.base.uri}")
@Slf4j
public class UsuarioControllerImpl implements UsuarioController {

	@Autowired
	public JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	public UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> autenticacionUsuario(@Valid @RequestBody LoginRequestDto dto) throws UserNotAuthException{
		log.info("[autenticacionUsuario] :: Inicio del Metodo" );
		Authentication sigin = null;
		sigin = jwtTokenUtil.createToken(dto.getUsername(), dto.getPassword());
		
		LoginResponseDto autPass = new LoginResponseDto();
		CodifyUserDto userPrincipal = (CodifyUserDto) sigin.getPrincipal();
		
		autPass.setToken(jwtTokenUtil.generateToken(sigin));
		autPass.setEmail(userPrincipal.getEmail());
		autPass.setFullName(userPrincipal.getFullName());
		autPass.setId(userPrincipal.getIdUsuario());
		log.info("[autenticacionUsuario] :: Fin del Metodo" );
		return new ResponseEntity<>(autPass, HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	@PreAuthorize("hasAuthority('Administrador')")
	public ResponseEntity<?> registrarUsuario(@Valid @RequestBody RegistrarRequestDto dto){
		log.info("[registrarUsuario] :: Inicio/Fin del Metodo" );
		return new ResponseEntity<>(usuarioService.registrarUsuario(dto) , HttpStatus.OK);
	}
	
}
