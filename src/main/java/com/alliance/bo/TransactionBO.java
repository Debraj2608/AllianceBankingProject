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
		Boolean statusTransaction=false;
		boolean statusDebitBalanceUpdate = false;
		boolean statusCreditBalanceUpdate = false;
		TransactionDAO transactionDAO= new TransactionDAO();
		
		String acc_no_from = debitAccount;
		double t_amount=debit.getTransaction_amount();
		
		GetAccountDAO getAccountDAO = new GetAccountDAO();
		//for from------------------------------------------------------------
		AccountModel debitAccountInfo = getAccountDAO.getAccountObject(acc_no_from);
		//double old_balance=(debitAccountInfo.getBalance());
		double old_balance = (debitAccountInfo.getBalance());
		System.out.println("debit "+old_balance);
		double new_balance = old_balance-t_amount;
		System.out.println("debit "+new_balance);
		//debitAccountInfo.setBalance((new_balance));
		//debitAccountInfo.setBalance(new_balance);
		//-------------------------------------------------------------
		
		//for to----------------------------------------------------------
		AccountModel creditAccountInfo = getAccountDAO.getAccountObject(creditAccount);
		double old_balance1 = (creditAccountInfo.getBalance());
		System.out.println("credit "+old_balance1);
		double new_balance1 = old_balance1+t_amount;
		System.out.println("credit "+new_balance1);
		//creditAccountInfo.setBalance((new_balance1));
		//----------------------------------------------------------
		statusTransaction = transactionDAO.doTransaction(debit,credit, debitAccountInfo, creditAccountInfo);
		statusDebitBalanceUpdate = transactionDAO.updateDebitAccountBalance(debitAccountInfo, new_balance);
		statusCreditBalanceUpdate = transactionDAO.updateCreditAccountBalance(creditAccountInfo, new_balance1);
		if(statusTransaction==true && statusDebitBalanceUpdate==true && statusCreditBalanceUpdate==true)
		{
			status = true;
		}
		return status;
	}
}