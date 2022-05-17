package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.security.CustomSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("username or password was incorrect");
			
		}
		return new CustomSecurityUser(user);

	}
	
	
	

}
