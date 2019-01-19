package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.util.HibernateUtil;

public class TransactionDAO 
{
	
	public Boolean doTransaction(TransactionModel debit,TransactionModel credit, String debitAccount, String creditAccount)
	{
		Boolean status=false;
		Session s= HibernateUtil.getSessionFactory();
		
		try 
		{
			Transaction tx= s.beginTransaction();
			//Debit Account
			AccountModel debitAccountObj = s.get(AccountModel.class, debitAccount);
			List<TransactionModel> debitTransactionList = debitAccountObj.getTransactionList();
			debitTransactionList.add(debit);
			s.persist(debit);
			
			tx.commit();
			
			Transaction tx2= s.beginTransaction();
			//Credit Account
			AccountModel creditAccountObj = s.get(AccountModel.class, creditAccount);
			List<TransactionModel> creditTransactionList = creditAccountObj.getTransactionList();
			creditTransactionList.add(credit);			
			s.persist(credit);

			tx2.commit();
			
			status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			status=false;
		}
		finally
		{
			s.close();
		}
		return status;
	}
	
	public boolean updateDebitAccountBalance(String debitAccount, double newDebitBalance)
	{
		Session s= HibernateUtil.getSessionFactory();
		boolean status = false;
		try
		{
			Transaction tx = s.beginTransaction();
			
			//System.out.println(newBalance);
			AccountModel debitAccountObj = s.get(AccountModel.class, debitAccount);
			//System.out.println(debitAccount+"debit");
			debitAccountObj.setBalance(newDebitBalance);
			//System.out.println(debitAccountObj.getBalance());
			s.saveOrUpdate(debitAccountObj);
			
			tx.commit();
			
			status = true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			status=false;
		}
		finally
		{
			s.close();
		}
		return status;
	}

	public boolean updateCreditAccountBalance(String creditAccount, double newCreditBalance)
	{
		Session s= HibernateUtil.getSessionFactory();
		boolean status = false;
		try
		{
			Transaction tx = s.beginTransaction();
			
			//System.out.println(creditAccount+"credit");
			AccountModel creditAccountObj = s.get(AccountModel.class, creditAccount);
			//System.out.println(newBalance1);
			creditAccountObj.setBalance(newCreditBalance);
			//System.out.println(creditAccountObj.getBalance());
			s.saveOrUpdate(creditAccountObj);
			
			tx.commit();
			
			status = true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			status=false;
		}
		finally
		{
			s.close();
		}
		return status;
	}
}