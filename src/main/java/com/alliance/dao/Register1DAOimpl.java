package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class Register1DAOimpl implements Register1DAO
{
	public boolean validate1Register(UserModel userModel) 
	{
		boolean status = false;
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory();
		try
		{
			tx = session.beginTransaction();
			session.save(userModel);
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