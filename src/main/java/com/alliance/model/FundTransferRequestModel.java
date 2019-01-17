package com.alliance.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "fund_transfer_request_master", uniqueConstraints = {@UniqueConstraint(columnNames = {"UserModel_customerID"})})
public class FundTransferRequestModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestID;
	
	@Column
	private Date requestTime = new Date();
	
	@Column
	private Date activationTime;
	
	@OneToOne
	private UserModel userModel;
	
	@Column 
	private boolean status;

	public FundTransferRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(Date activationTime) {
		this.activationTime = activationTime;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}