package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.example.demo.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;
import com.example.demo.repo.Employeerepo;
@Service
public class EmpServiceImpl implements EmpService{

@Autowired
private Employeerepo repo;

private RestTemplate restTemplate;

@Bean
public RestTemplate getRestTemplate() {
	return new RestTemplate();
}

	public EmpServiceImpl(RestTemplate restTemplate) {
	super();
	this.restTemplate = restTemplate;
}
	public EmpServiceImpl() {
	super();
	// TODO Auto-generated constructor stub
}
	@Override
	public Employee getEmpById(String empid) {
		// TODO Auto-generated method stub
		return this.repo.getOne(Long.parseLong(empid));
	}
	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return this.repo.save(emp);
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public void deleteEmployeeByID(String empid) {
		// TODO Auto-generated method stub
		Employee eid=repo.getOne(Long.parseLong(empid));
		repo.delete(eid);
		
	}
	@Override
	public void updateEmployee(Employee emp, int empid) {
		List<Employee> list=repo.findAll();
		list.stream().map(e->{
			if(e.getEmpid()==empid) {
				e.setEmpname(emp.getEmpname());
				e.setEmpaddress(emp.getEmpaddress());
				e.setEmpsallary(emp.getEmpsallary());
				
				
			}
			return e;
		}).collect(Collectors.toList());
		
	}
	/*
	 * @Override public Employee getEmpByName(String empname) { // TODO
	 * Auto-generated method stub return repo.getEmpByName(empname); }
	 */
	@Override
	public String getBookdata() {
		return restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employees",String.class); 
		
	}

}
