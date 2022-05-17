package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;
import com.example.demo.service.EmpService;

@RestController
@Component
public class EmployeeController {
	
	@Autowired
	private EmpService empservice;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/employee/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String empid){
		Employee emp=empservice.getEmpById(empid);
		if(emp==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));
		
		
	}
	@PostMapping("/employee/emp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		Employee e=null;
		try {
			e=empservice.addEmployee(emp);
			return ResponseEntity.of(Optional.of(e));
		}
		catch(Exception e1) {
			e1.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> emp=empservice.getAllEmployees();
		if(emp.size()<0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}
		else {
			return ResponseEntity.of(Optional.of(emp));
		}
		
	}
	
	@DeleteMapping("/employees/{empid}")
	public ResponseEntity<Employee> deleteEmpById(@PathVariable String empid){
		try {
			this.empservice.deleteEmployeeByID(empid);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/employees/{empid}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp,@PathVariable("empid") int empid){
	 try {
		 this.empservice.updateEmployee(emp,empid);
		 return ResponseEntity.status(HttpStatus.OK).build();
	 }
	 catch(Exception e) {
		 e.printStackTrace();
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 }
	}
	
	/*
	 * @GetMapping("/employee1/{empname}") public ResponseEntity<Employee>
	 * getEmployeeByName(@PathVariable String empname){ Employee
	 * emp=empservice.getEmpByName(empname); if(emp==null) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).build(); } return
	 * ResponseEntity.of(Optional.of(emp)); }
	 */
	@GetMapping("/externalapi")
	public ResponseEntity<Employee> CallBookApi(){
		try {
			this.empservice.getBookdata();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
