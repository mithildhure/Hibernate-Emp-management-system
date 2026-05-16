package com.proj.hib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_id;
	
	@Column(name = "name", nullable = false)
	private String employee_name;
	
	@Column(name = "username", unique = true, nullable = false)
	private String emp_username;
	
	@Column(name = "email", unique = true, nullable = false)
	private String emp_email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private double salary;
	
	@Column(nullable = false)
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
		
}
