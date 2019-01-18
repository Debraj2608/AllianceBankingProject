package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.util.HibernateUtil;

public class CheckAccountValidityDAO 
{
	public boolean checkValidity(String account_no)
	{
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			AccountModel account = session.get(AccountModel.class, account_no);
			System.out.println(account.getAccount_no());
			if(account != null)
			{
				status = true;
			}
			tx.commit();
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