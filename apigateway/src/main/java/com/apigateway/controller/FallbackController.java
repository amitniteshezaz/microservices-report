package com.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("userservicefallback")
	public String userServiceFallback() {
		return"user service down";
	}

	
	@GetMapping("contactservicefallback")
	public String contactServiceFallback() {
		return"contact service down";
	}
}
