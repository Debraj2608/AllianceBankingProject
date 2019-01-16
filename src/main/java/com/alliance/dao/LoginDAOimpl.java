package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class LoginDAOimpl implements LoginDAO 
{
	public UserModel validate(UserModel um) 
	{
		Boolean status;
		Session session = HibernateUtil.getSessionFactory();
		String userid = um.getCustomerID();
		String password = um.getPassword();
		UserModel userRecord = null;
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			List s = session.createQuery("from UserModel where customerID='"+userid+"' and password='"+password+"'").list();
			tx.commit();
			if(s.isEmpty())
			{
				userRecord = null;
			}
			else
			{
				userRecord = (UserModel) s.get(0);
			}
		}
		finally
		{
			session.close();
		}
		return userRecord;
			
	}
}