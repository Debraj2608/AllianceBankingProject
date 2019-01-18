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
		TransactionDAO trandsactionDAO= new TransactionDAO();
		
		String acc_no_from = debitAccount;
		double t_amount=debit.getTransaction_amount();
		
		GetAccountDAO getAccountDAO = new GetAccountDAO();
		//for from------------------------------------------------------------
		AccountModel debitAccountInfo = getAccountDAO.getAccountObject(acc_no_from);
		//double old_balance=(debitAccountInfo.getBalance());
		double old_balance = (debitAccountInfo.getBalance());
		double new_balance = old_balance-t_amount;
		//debitAccountInfo.setBalance((new_balance));
		debitAccountInfo.setBalance(new_balance);
		//-------------------------------------------------------------
		
		//for to----------------------------------------------------------
		AccountModel creditAccountInfo = getAccountDAO.getAccountObject(creditAccount);
		double old_balance1 = (creditAccountInfo.getBalance());
		double new_balance1 = old_balance1+t_amount;
		creditAccountInfo.setBalance((new_balance1));
		//----------------------------------------------------------
		status=trandsactionDAO.doTransaction(debit,credit, debitAccountInfo, creditAccountInfo);
		return status;
	}

}
