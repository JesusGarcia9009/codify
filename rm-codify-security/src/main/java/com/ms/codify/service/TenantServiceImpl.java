package com.ms.codify.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.codify.dto.TenantDto;
import com.ms.codify.entities.Tenant;
import com.ms.codify.repository.TenantRepository;

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
public class TenantServiceImpl implements TenantService {

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<TenantDto> listarTenants() {
		log.info("[listarTenants]::inicio de metodo");
		List<TenantDto> result = new ArrayList<>();
		List<Tenant> tenants = tenantRepository.findAll();
		for (Tenant tenant : tenants) {
			result.add(mapper.map(tenant, TenantDto.class));
		}
		log.info("[listarTenants]::fin de metodo");
		return result;
	}

	

}
