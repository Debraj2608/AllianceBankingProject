package com.alliance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class GetTransactionListDAO 
{
	public List<TransactionModel> transactionList(UserModel user)
	{
		List<TransactionModel> list = new ArrayList<TransactionModel>();
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			UserModel currentUser = session.get(UserModel.class, user.getCustomerID());
			AccountModel account = currentUser.getAccountModel();
			list = account.getTransactionList();
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
		return list;
	}
}