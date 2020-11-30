package com.ms.codify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.dto.TenantDto;
import com.ms.codify.exception.DataNotFoundException;
import com.ms.codify.service.TenantService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${api.codify.base.uri}/tenant")
@Slf4j
public class TenantControllerImpl implements TenantController {

	@Autowired
	public TenantService tenantService;
	
	@Override
	@GetMapping("/listar")
	@PreAuthorize("hasAuthority('Administrador')")
	public ResponseEntity<List<TenantDto>> listarPerfiles() throws DataNotFoundException {
		log.info("[obtenerListadoCampannas] ::Inicio del metodo");
	    List<TenantDto> data = tenantService.listarTenants();
	    log.info("[obtenerListadoCampannas]::fin del metodo");
	    return new ResponseEntity<>(data, data.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}
	
}
