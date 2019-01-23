package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.util.HibernateUtil;

public class CheckDebitAccountBalanceDAO 
{
	public boolean checkDebitAccountBalance(String accountNumber, double transactionAmount)
	{
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			AccountModel account = session.get(AccountModel.class, accountNumber);
			double currentBalance = account.getBalance();
			tx.commit();
			//System.out.println(currentBalance);
			//System.out.println(transactionAmount);
			if(currentBalance>=transactionAmount)
			{
				status = true;
			}
		}
		catch(Exception e)
		{
			tx.rollback();
			status = false;
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return status;
	}
}