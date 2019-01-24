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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table (name = "account_master")

public class AccountModel implements Serializable {
		
		private String account_no;
		
		private double balance;
		
		private List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		
		private BranchModel branchModel;
		
		@Id
		public String getAccount_no() {
			return account_no;
		}
		public void setAccount_no(String account_no) {
			this.account_no = account_no;
		}
		
		@ManyToOne(fetch = FetchType.EAGER)
		public BranchModel getBranchModel() {
			return branchModel;
		}
		public void setBranchModel(BranchModel branchModel) {
			this.branchModel = branchModel;
		}
		
		@Column
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name = "AccountNumber")
		public List<TransactionModel> getTransactionList() 
		{
			return transactionList;
		}
		public void setTransactionList(List<TransactionModel> transactionList) {
			this.transactionList = transactionList;
		}
}