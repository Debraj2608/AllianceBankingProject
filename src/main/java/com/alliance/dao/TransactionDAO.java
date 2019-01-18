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
	public Boolean doTransaction(TransactionModel debit,TransactionModel credit, AccountModel debitAccount, AccountModel creditAccount)
	{
		Boolean status=false;
		Session s= HibernateUtil.getSessionFactory();
		Transaction tx= s.beginTransaction();
		try 
		{
			//s.save(tm);
			//s.save(tm);
			
			List<TransactionModel> debitList = new ArrayList<TransactionModel>();
			debitList.add(debit);
			debitAccount.setTransactionList(debitList);
			s.persist(debit);
			s.saveOrUpdate(debitAccount);
			
			List<TransactionModel> creditList = new ArrayList<TransactionModel>();
			creditList.add(credit);
			creditAccount.setTransactionList(creditList);
			s.persist(credit);
			s.saveOrUpdate(creditAccount);
			
			tx.commit();
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
}