package com.emp.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

	@RestController
	public class EmployeeController {

	@Autowired
	private EmployeeService service;
		@GetMapping("/empid")
		public ResponseEntity<List<Employee>> getEmployee(){
			List<Employee> list=service.getEmp();
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(list));
			
		}
		@PostMapping("/emp")
		public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
			Employee b=null;
			try {
				b=this.service.addEmployee(emp);
				return ResponseEntity.of(Optional.of(b));
			}
			catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				
			}
		}
		@GetMapping("/book/{empid}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable String empId) {
			Employee emp=service.getEmployeeById(empId);
			if(emp==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(emp));
		}
	
	}



