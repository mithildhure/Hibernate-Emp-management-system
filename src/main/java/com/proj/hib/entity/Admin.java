package com.proj.hib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_details")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String admin_user;
	
	@Column(nullable = false)
	private String admin_pass;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_user() {
		return admin_user;
	}
	public void setAdmin_user(String admin_user) {
		this.admin_user = admin_user;
	}
	public String getAdmin_pass() {
		return admin_pass;
	}
	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}
	
}
