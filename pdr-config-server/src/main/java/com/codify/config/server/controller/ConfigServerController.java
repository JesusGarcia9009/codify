package com.codify.config.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BS2
 */
@RestController
@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, path = {
		"${spring.cloud.config.server.prefix}" })
public class ConfigServerController {

	@RequestMapping({ "/error" })
	public String configWithError() {
		return "No config error found";
	}

}
