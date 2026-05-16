package com.proj.hib.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department_details")
public class Department {

	@Id
	private int department_id;
	
	@Column(unique = true, nullable = false)
	private String department_name;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> emp_lists;

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public List<Employee> getEmp_lists() {
		return emp_lists;
	}

	public void setEmp_lists(List<Employee> emp_lists) {
		this.emp_lists = emp_lists;
	}
	
}
