package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class LoginDAOimpl implements LoginDAO 
{
	public Boolean validate(UserModel lm) 
	{
		Boolean status;
		Session session = HibernateUtil.getSessionFactory();
		String userid = lm.getCustomerID();
		String password = lm.getPassword();
		List s = session.createQuery("from UserModel where customerID='"+userid+"' and password='"+password+"'").list();
		if (s.isEmpty()) 
		{
			status = false;
			
		} 
		else 
		{
			status = true;
		}
		return status;
	}
}