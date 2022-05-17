package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empid;

	private String empname;
	private String empaddress;
	private int empsallary;
	public Long getEmpid() {
		return empid;
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}
	public int getEmpsallary() {
		return empsallary;
	}
	public void setEmpsallary(int empsallary) {
		this.empsallary = empsallary;
	}
	public Employee(Long empid, String empname, String empaddress, int empsallary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empaddress = empaddress;
		this.empsallary = empsallary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empaddress=" + empaddress + ", empsallary="
				+ empsallary + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
