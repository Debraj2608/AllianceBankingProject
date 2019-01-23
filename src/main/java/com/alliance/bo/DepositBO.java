package com.alliance.bo;

import java.util.Date;
import java.util.List;

import com.alliance.dao.DepositDAO;
import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.model.UserModel;
import com.alliance.util.AutogenTransaction;

public class DepositBO 
{
	DepositDAO depositDAO = new DepositDAO();
	boolean status = false;
	public boolean deposited(UserModel user, double amount)
	{
		boolean statusDeposited = false;
		double currentBalance = user.getAccountModel().getBalance();
		double updatedBalance = currentBalance+amount;
		statusDeposited = depositDAO.deposited(user, updatedBalance);
		
		boolean statusTransaction = false;
		TransactionModel transaction = new TransactionModel();
		AutogenTransaction autoGenTransaction = new AutogenTransaction();
		List<String> transactionIDList=autoGenTransaction.getTransactionID();
		transaction.setTransaction_amount(amount);
		transaction.setTransaction_date(new Date());
		transaction.setTransaction_id(transactionIDList.get(0));
		transaction.setTransaction_type("deposit");
		transaction.setToOrFromAccount("Self Deposit");
		AccountModel account = user.getAccountModel();
		String accountNo = account.getAccount_no();
		statusTransaction = depositDAO.transaction(accountNo, transaction);
		if(statusDeposited == true && statusTransaction == true)
		{
			status = true;
		}
		else
		{
			status = false;
		}
		return status;
	}
}
