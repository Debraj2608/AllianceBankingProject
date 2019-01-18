package com.alliance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "admin_master")
@DynamicUpdate
public class AdminModel 
{
	@Id
	private String adminID;
	@Column
	private String password;
	
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
