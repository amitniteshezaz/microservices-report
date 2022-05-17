package spring.books.Springbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import spring.books.Springbooks.helper.JwtUtil;
import spring.books.Springbooks.model.JwtRequest;
import spring.books.Springbooks.model.JwtResponse;
import spring.books.Springbooks.service.CustomUserDetailsService;

@RestController
public class JwtController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value ="/token",method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println("jwt request");
		try {
			System.out.println("hi");
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			System.out.println("ho");
		}catch(UsernameNotFoundException e) { 
			e.printStackTrace();
			throw new Exception("Bad Credentials");
			
		}
		
		UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(userDetails);
		System.out.println("jwt" + token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
