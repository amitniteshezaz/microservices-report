package com.springcore.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Emp {
	private String empname;
	private List<String> phone;
	private Set<String> address;
	private Map<String,String> courses;
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public List<String> getPhone() {
		return phone;
	}
	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	public Set<String> getAddress() {
		return address;
	}
	public void setAddress(Set<String> address) {
		this.address = address;
	}
	public Map<String, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Emp [empname=" + empname + ", phone=" + phone + ", address=" + address + ", courses=" + courses + "]";
	}
	public Emp(String empname, List<String> phone, Set<String> address, Map<String, String> courses) {
		super();
		this.empname = empname;
		this.phone = phone;
		this.address = address;
		this.courses = courses;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
