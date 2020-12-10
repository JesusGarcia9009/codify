package com.ms.codify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.dto.ProfileResponseDto;
import com.ms.codify.service.ProfileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${api.codify.base.uri}")
@Slf4j
public class ProfileControllerImpl implements ProfileController {

	@Autowired
	public ProfileService profileService;
	
	@Override
	@GetMapping("/get-profile-list")
	@PreAuthorize("hasAuthority('Administrator')")
	public ResponseEntity<List<ProfileResponseDto>> getAllProfiles() {
		log.info("[getAllProfiles]::start of method");
		List<ProfileResponseDto> data = profileService.getAll();
		log.info("[getAllProfiles]:: end of method");
		return new ResponseEntity<>(data, data.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}
	
}
