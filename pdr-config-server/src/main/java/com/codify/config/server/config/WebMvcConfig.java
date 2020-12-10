package com.codify.config.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Configuracion de los url permitidad por aplicacion.
 * 
 * @author NelsonAlvaradoVidal
 *
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * Metodo de WebMvcConfig
	 *
	 * @param registry
	 *
	 * @author nalvarado bs2
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}