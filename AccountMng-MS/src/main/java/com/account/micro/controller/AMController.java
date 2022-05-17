package com.account.micro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AMController {
	
	@GetMapping("/check")
	public String check() {
		return "check";
	}
	
	@GetMapping("wish")
	public String wish() {
		return "wish";
	}

}
