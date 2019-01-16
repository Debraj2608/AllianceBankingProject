package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class AdminLinkDAO 
{
	public boolean insertDetails(AccountModel accountModel, UserModel userModel)
	{
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		UserModel user = null; 
		String customerID = userModel.getCustomerID();
		try
		{
			tx = session.beginTransaction();
			session.save(accountModel);
			user = session.get(UserModel.class, customerID);
			user.setAccountModel(accountModel);
			tx.commit();
			status = true;
		}
		catch(Exception e)
		{
			System.out.println(e);
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