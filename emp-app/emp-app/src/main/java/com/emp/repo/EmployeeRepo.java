package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	//@Query("Select * from emp where name=Amit")
	//public Employee getEmployeeByName();
		
		
	}
	


