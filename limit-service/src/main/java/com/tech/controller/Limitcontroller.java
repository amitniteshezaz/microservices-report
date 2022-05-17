package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.bean.LimitsConfiguration;

@RestController
public class Limitcontroller {
	@Autowired
	private LimitsConfiguration limits;
	@GetMapping("/limits")
	public LimitsConfiguration returnLimit() {
		return new LimitsConfiguration(limits.getMaximum(),limits.getMinimum());
		
	}
	

}
