package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contacts;
import com.contact.seervice.ContactService;

@RestController
public class ContactController {
	@Autowired
	private ContactService service;
	
	@GetMapping("/contact/user/{userId}")
	public List<Contacts> getContactsofuser(@PathVariable("userId") Long UserId){
		return service.getContactsOfUser(UserId);
	}

}
