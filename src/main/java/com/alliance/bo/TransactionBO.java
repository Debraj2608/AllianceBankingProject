package com.alliance.bo;

import com.alliance.dao.GetAccountDAO;
import com.alliance.dao.TransactionDAO;
import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;

public class TransactionBO {
	
	
	public Boolean doTransaction(TransactionModel tm,TransactionModel tm1, String acc_no_to_transfer)
	{
		Boolean status=false;
		TransactionDAO td= new TransactionDAO();
		
		AccountModel acc_no_from1=tm.getAccountModel();
		String acc_no_from = acc_no_from1.getAccount_no();
		double t_amount=tm.getTransaction_amount();
		
		GetAccountDAO gad= new GetAccountDAO();
		//for from------------------------------------------------------------
		AccountModel am_from=gad.getAccountObject(acc_no_from);
		double old_balance=(am_from.getBalance());
		double new_balance=old_balance-t_amount;
		am_from.setBalance((new_balance));
		//-------------------------------------------------------------
		
		//for to----------------------------------------------------------
		AccountModel am_to=gad.getAccountObject(acc_no_to_transfer);
		double old_balance1=(am_to.getBalance());
		double new_balance1=old_balance1+t_amount;
		am_to.setBalance((new_balance1));
		//----------------------------------------------------------
		status=td.doTransaction(tm,tm1, am_from, am_to);
		return status;
	}

}
