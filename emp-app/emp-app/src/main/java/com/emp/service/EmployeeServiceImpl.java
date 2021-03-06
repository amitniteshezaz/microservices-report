package com.emp.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Employee;
import com.emp.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepo repo;
	@Override
	public List<Employee> getEmp() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return repo.getOne(Integer.parseInt(id));
	}
//	@Override
//	public Employee getEmployeeByName() {
//		// TODO Auto-generated method stub
//		return repo.getEmployeeByName();
//	}
	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}
	

}
