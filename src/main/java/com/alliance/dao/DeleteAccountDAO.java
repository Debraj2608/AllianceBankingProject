package com.alliance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class DeleteAccountDAO 
{

	public boolean deleteAccount(UserModel model) 
	{
		boolean status = false;
		String customerID = model.getCustomerID();
		System.out.println(customerID);
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Query query = session.createQuery("delete from AccountModel where userModel_customerID = '"+customerID+"'");
			int a = query.executeUpdate();
			tx.commit();
			System.out.println(a);
			if(a>0)
				status = true;
		}
		
		catch(Exception e)
		{
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
