package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class MyAccountDAO 
{
	public UserModel getUpdates(String customerID)
	{
		UserModel userUpdated = null;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			userUpdated = session.get(UserModel.class, customerID);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		return userUpdated;
	}
}