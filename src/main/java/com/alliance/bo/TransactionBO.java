package com.alliance.bo;

import com.alliance.dao.GetAccountDAO;
import com.alliance.dao.TransactionDAO;
import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.model.UserModel;

public class TransactionBO {
	
	
	public Boolean doTransaction(TransactionModel debit,TransactionModel credit, String creditAccount, String debitAccount)
	{
		Boolean status=false;
		TransactionDAO td= new TransactionDAO();
		
		//AccountModel acc_no_from1=debit.get
		String acc_no_from = debitAccount;
		double t_amount=debit.getTransaction_amount();
		
		GetAccountDAO gad= new GetAccountDAO();
		//for from------------------------------------------------------------
		AccountModel debitAccountInfo=gad.getAccountObject(acc_no_from);
		//double old_balance=(debitAccountInfo.getBalance());
		double old_balance=(debitAccountInfo.getBalance());
		double new_balance=old_balance-t_amount;
		//debitAccountInfo.setBalance((new_balance));
		debitAccountInfo.setBalance(new_balance);
		//-------------------------------------------------------------
		
		//for to----------------------------------------------------------
		AccountModel creditAccountInfo=gad.getAccountObject(creditAccount);
		double old_balance1=(creditAccountInfo.getBalance());
		double new_balance1=old_balance1+t_amount;
		creditAccountInfo.setBalance((new_balance1));
		//----------------------------------------------------------
		status=td.doTransaction(debit,credit, debitAccountInfo, creditAccountInfo);
		return status;
	}

}
