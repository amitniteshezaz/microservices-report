package com.user.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Contacts;
import com.user.entity.User;
import com.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable("userId") Long userId) {
		User user=service.getUser(userId);
		List contacts=this.restTemplate.getForObject("http://localhost:9092/contact/user/133",List.class);
		
		user.setContacts(contacts);
		
		return user;
	}

}
