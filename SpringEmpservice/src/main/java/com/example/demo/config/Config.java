package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class Config {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
