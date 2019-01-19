package com.alliance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "delete_info_master")
public class DeletedAccountsInfoModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deletionID;
	
	@Column
	private Date deletionDateInfo;
	
	@Column
	private String firstName;
	
	@Column
	private String middleName;
	
	@Column
	private String lastName;

	@Column
	private String accountNo;
	
	@Column
	private String customerID;
		
	public int getDeletionID() {
		return deletionID;
	}

	public void setDeletionID(int deletionID) {
		this.deletionID = deletionID;
	}

	public Date getDeletionDateInfo() {
		return deletionDateInfo;
	}

	public void setDeletionDateInfo(Date deletionDateInfo) {
		this.deletionDateInfo = deletionDateInfo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	
}
