package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;


public interface EmpService {
	public Employee getEmpById(String empid);

	public Employee addEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public void deleteEmployeeByID(String empid);

	public void updateEmployee(Employee emp, int empid);

	public String getBookdata();

	//public Employee getEmpByName(String empname);

}
