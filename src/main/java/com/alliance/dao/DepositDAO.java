package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class DepositDAO 
{
	public boolean deposited(UserModel user, double updatedBalance)
	{
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			UserModel currentUser = session.get(UserModel.class, user.getCustomerID());
			AccountModel account = currentUser.getAccountModel();
			account.setBalance(updatedBalance);
			currentUser.setAccountModel(account);
			session.persist(account);
			session.save(currentUser);
			tx.commit();
			status = true;
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
