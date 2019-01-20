package com.alliance.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table (name = "account_master")

public class AccountModel implements Serializable {
		
		private String account_no;
		
		private String branch_code;
		
		private double balance;
		
		private List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		
		@Id
		public String getAccount_no() {
			return account_no;
		}
		public void setAccount_no(String account_no) {
			this.account_no = account_no;
		}
		
		@Column
		public String getBranch_code() {
			return branch_code;
		}
		public void setBranch_code(String branch_code) {
			this.branch_code = branch_code;
		}
		
		@Column
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name = "AccountNumber")
		public List<TransactionModel> getTransactionList() 
		{
			return transactionList;
		}
		public void setTransactionList(List<TransactionModel> transactionList) {
			this.transactionList = transactionList;
		}
}