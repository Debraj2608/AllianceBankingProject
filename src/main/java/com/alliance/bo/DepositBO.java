package com.alliance.bo;

import com.alliance.dao.DepositDAO;
import com.alliance.model.UserModel;

public class DepositBO 
{
	DepositDAO depositDAO = new DepositDAO();
	public boolean deposited(UserModel user, double amount)
	{
		boolean status = false;
		double currentBalance = user.getAccountModel().getBalance();
		double updatedBalance = currentBalance+amount;
		status = depositDAO.deposited(user, updatedBalance);
		return status;
	}
}
