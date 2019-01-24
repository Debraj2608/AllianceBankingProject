package com.alliance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table (name = "cust_master",uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@DynamicUpdate
public class UserModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private Date dob;
	private String city;
	private String contactNumber;
	private String occupation;
	private String customerID;
	private String password;
	private boolean fundsTransferStatus;
	private String account_type;
	private AccountModel accountModel;
	public UserModel() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Column
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	@Column
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Id
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isFundsTransferStatus() 
	{
		return fundsTransferStatus;
	}
	public void setFundsTransferStatus(boolean fundsTransferStatus) 
	{
		this.fundsTransferStatus = fundsTransferStatus;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public AccountModel getAccountModel() 
	{
		return accountModel;
	}
	public void setAccountModel(AccountModel accountModel) 
	{
		this.accountModel = accountModel;
	}
	
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}	
	
	
	
}