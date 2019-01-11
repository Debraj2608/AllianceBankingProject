package com.alliance.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "account_master")
public class AccountModel implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String account_no;
		
		
		private UserModel userModel;
		
		
		private String branch_code;
		
		@Id
		public String getAccount_no() {
			return account_no;
		}
		public void setAccount_no(String account_no) {
			this.account_no = account_no;
		}
		
		@OneToOne
		public UserModel getUserModel() {
			return userModel;
		}
		public void setUserModel(UserModel userModel) {
			this.userModel = userModel;
		}
		
		@Column
		public String getBranch_code() {
			return branch_code;
		}
		public void setBranch_code(String branch_code) {
			this.branch_code = branch_code;
		}
		
		
}
