package com.ms.codify.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.dto.PerfilesDto;
import com.ms.codify.exception.DataNotFoundException;
import com.ms.codify.service.PerfilService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${api.codify.base.uri}/perfil")
@Slf4j
public class PerfilControllerImpl implements PerfilController {

	private final PerfilService perfilService;
	
	@Autowired
    public PerfilControllerImpl(PerfilService perfilService) {
        this.perfilService = perfilService;
    }
	
	@Override
	@GetMapping("/listar")
	@PreAuthorize("hasAuthority('Administrador')")
	public ResponseEntity<List<PerfilesDto>> listarPerfiles() throws DataNotFoundException {
		log.info("[obtenerListadoCampannas] ::Inicio del metodo");
	    List<PerfilesDto> data = perfilService.listarPerfiles();
	    log.info("[obtenerListadoCampannas]::fin del metodo");
	    return new ResponseEntity<>(data, data.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}
	
    @GetMapping("/perfil/{idPerfil}")
    @PreAuthorize("hasAuthority('Administrador')")
    public ResponseEntity<PerfilesDto> get(@PathVariable("idPerfil") Long idPerfil) {
    	log.info("[get] ::Inicio del metodo");
    	PerfilesDto data=  perfilService.obtenerPerfil(idPerfil);
        log.info("[get] ::fin del metodo");
        return new ResponseEntity<>(data, Objects.isNull(data) ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAuthority('Administrador')")
    public ResponseEntity<PerfilesDto> post(@RequestBody PerfilesDto perfil) {
    	log.info("[post] ::Inicio del metodo");
    	PerfilesDto data = perfilService.guardarPerfil(perfil);
        log.info("[post] ::fin del metodo");
        return new ResponseEntity<>(data, Objects.isNull(data) ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idPerfil}")
    @PreAuthorize("hasAuthority('Administrador')")
    public void delete(@PathVariable("idPerfil") Long idPerfil) {
    	log.info("[delete] ::Inicio/fin del metodo");
    	perfilService.eliminarPerfil(idPerfil);
    }
	
}
