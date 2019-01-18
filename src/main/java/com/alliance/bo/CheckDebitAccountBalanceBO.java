package com.alliance.bo;

import com.alliance.dao.CheckDebitAccountBalanceDAO;

public class CheckDebitAccountBalanceBO 
{
	CheckDebitAccountBalanceDAO checkBalanceDAO = new CheckDebitAccountBalanceDAO();
	public boolean checkDebitAccountBalance(String accountNumber, double transactionAmount)
	{
		boolean status = false;
		status = checkBalanceDAO.checkDebitAccountBalance(accountNumber, transactionAmount);
		return status;
	}
}
