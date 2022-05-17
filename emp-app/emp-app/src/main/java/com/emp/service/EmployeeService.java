package com.emp.service;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmp();

	public Employee getEmployeeById(String id);

	public Employee addEmployee(Employee emp);

	//public Employee getEmployeeByName();

}
