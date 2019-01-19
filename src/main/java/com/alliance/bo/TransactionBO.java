package com.alliance.bo;

import com.alliance.dao.GetAccountDAO;
import com.alliance.dao.TransactionDAO;
import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.model.UserModel;

public class TransactionBO {
	
	
	public Boolean doTransaction(TransactionModel debit,TransactionModel credit, String creditAccount, String debitAccount)
	{
		boolean status = false;
		Boolean statusTransaction = false;
		boolean statusDebitBalanceUpdate = false;
		boolean statusCreditBalanceUpdate = false;
		TransactionDAO transactionDAO = new TransactionDAO();
		
		double t_amount = debit.getTransaction_amount();
		
		GetAccountDAO getAccountDAO = new GetAccountDAO();
		//Debit Account 
		AccountModel debitAccountInfo = getAccountDAO.getAccountObject(debitAccount);
		double old_balance = (debitAccountInfo.getBalance());
		double new_balance = old_balance-t_amount;
		
		//-------------------------------------------------------------------------------------------------
		
		//Credit Account
		AccountModel creditAccountInfo = getAccountDAO.getAccountObject(creditAccount);
		double old_balance1 = (creditAccountInfo.getBalance());
		double new_balance1 = old_balance1+t_amount;
		
		//-------------------------------------------------------------------------------------------------
		statusTransaction = transactionDAO.doTransaction(debit,credit, debitAccount, creditAccount);
		statusDebitBalanceUpdate = transactionDAO.updateDebitAccountBalance(debitAccount, new_balance);
		statusCreditBalanceUpdate = transactionDAO.updateCreditAccountBalance(creditAccount, new_balance1);
		if(statusTransaction == true && statusDebitBalanceUpdate == true && statusCreditBalanceUpdate == true)
		{
			status = true;
		}
		return status;
	}
}