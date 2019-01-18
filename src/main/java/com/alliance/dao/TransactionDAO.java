package com.alliance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.util.HibernateUtil;

public class TransactionDAO 
{
	
	public Boolean doTransaction(TransactionModel debit,TransactionModel credit, AccountModel debitAccountInfo, AccountModel creditAccountInfo)
	{
		Boolean status=false;
		Session s= HibernateUtil.getSessionFactory();
		
		try 
		{
			//s.save(tm);
			//s.save(tm);
			Transaction tx= s.beginTransaction();
			//List<TransactionModel> debitList = new ArrayList<TransactionModel>();
			//debitList.add(debit);
			String debitAccountNumber = debitAccountInfo.getAccount_no();
			AccountModel debitAccountObj = s.get(AccountModel.class, debitAccountNumber);
			List<TransactionModel> debitTransactionList = debitAccountObj.getTransactionList();
			debitTransactionList.add(debit);
			s.persist(debit);
			//s.saveOrUpdate(debitAccountInfo);
			tx.commit();
			
			Transaction tx2= s.beginTransaction();
			String creditAccountNumber = creditAccountInfo.getAccount_no();
			AccountModel creditAccountObj = s.get(AccountModel.class, creditAccountNumber);
			List<TransactionModel> creditTransactionList = creditAccountObj.getTransactionList();
			creditTransactionList.add(credit);
			s.persist(credit);
			//s.saveOrUpdate(creditAccountInfo);
			
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
	
	public boolean updateDebitAccountBalance(AccountModel debitAccountInfo, double newBalance)
	{
		Session s= HibernateUtil.getSessionFactory();
		boolean status = false;
		try
		{
			Transaction tx = s.beginTransaction();
			String debitAccount = debitAccountInfo.getAccount_no();
			System.out.println(newBalance);
			AccountModel debitAccountObj = s.get(AccountModel.class, debitAccount);
			System.out.println(debitAccount+"debit");
			debitAccountObj.setBalance(newBalance);
			System.out.println(debitAccountObj.getBalance());
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

	public boolean updateCreditAccountBalance(AccountModel creditAccountInfo, double newBalance1)
	{
		Session s= HibernateUtil.getSessionFactory();
		boolean status = false;
		try
		{
			Transaction tx = s.beginTransaction();
			String creditAccount = creditAccountInfo.getAccount_no();
			System.out.println(creditAccount+"credit");
			AccountModel creditAccountObj = s.get(AccountModel.class, creditAccount);
			System.out.println(newBalance1);
			creditAccountObj.setBalance(newBalance1);
			System.out.println(creditAccountObj.getBalance());
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