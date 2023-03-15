package com.usuario1.service1.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Restemplate1Config {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
