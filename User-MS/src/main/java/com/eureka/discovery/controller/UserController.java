package com.eureka.discovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Environment env;
	@GetMapping("/status/check")
	public String status() {
		return "Port number" +env.getProperty("local.server.port");
	}
	
	@GetMapping("/wish")
	public String getWish() {
		String url="http://localhost:8060/account/wish";
		String result=restTemplate.getForObject(url, String.class);
		return "Hello" + result;
	}
	

}
