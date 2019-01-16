package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.util.HibernateUtil;

public class TransactionDAO 
{
	public Boolean doTransaction(TransactionModel tm,TransactionModel tm1, AccountModel am_to, AccountModel am_from)
	{
		Boolean status=false;
		Session s= HibernateUtil.getSessionFactory();
		Transaction tx= s.beginTransaction();
		
		try 
		{
			s.save(tm);
			s.save(tm);
			s.saveOrUpdate(am_to);
			s.saveOrUpdate(am_from);
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