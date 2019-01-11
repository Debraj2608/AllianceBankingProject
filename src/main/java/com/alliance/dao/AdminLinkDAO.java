package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.util.HibernateUtil;

public class AdminLinkDAO 
{
	public boolean insertDetails(AccountModel accountModel)
	{
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(accountModel);
			tx.commit();
			status = true;
		}
		catch(Exception e)
		{
			tx.rollback();
			status = false;
		}
		finally
		{
			session.close();
		}
		return status;
	}
}