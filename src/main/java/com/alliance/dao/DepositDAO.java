package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class DepositDAO 
{
	public boolean deposited(UserModel user, double updatedBalance)
	{
		boolean statusDeposited = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			UserModel currentUser = session.get(UserModel.class, user.getCustomerID());
			AccountModel account = currentUser.getAccountModel();
			account.setBalance(updatedBalance);
			currentUser.setAccountModel(account);
			session.persist(account);
			session.save(currentUser);
			tx.commit();
			statusDeposited = true;
		}
		catch(Exception e)
		{
			tx.rollback();
			statusDeposited = false;
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return statusDeposited;
	}
	
	public boolean transaction(String accountNo, TransactionModel transaction)
	{
		boolean statusTransaction = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			AccountModel account = session.get(AccountModel.class, accountNo);
			List<TransactionModel> transactionList = account.getTransactionList();
			transactionList.add(transaction);
			session.persist(transaction);
			session.save(account);
			tx.commit();
			statusTransaction = true;
		}
		catch(Exception e)
		{
			tx.rollback();
			statusTransaction = false;
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return statusTransaction;		
	}
}
