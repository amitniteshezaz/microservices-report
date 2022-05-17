package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;


@Repository
public interface Employeerepo extends JpaRepository<Employee, Long>{
	//@Query("select u from employee u where empname=:c")
	//Employee getEmpByName(@Param("c") String empname);
	//@Query(value = "select * from employee e where e.email_address = ?1", nativeQuery = true)
	//@Query("select u from employee u")
	//public List<Employee> getAllEmployees();

}
