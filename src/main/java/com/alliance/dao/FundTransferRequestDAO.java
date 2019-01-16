package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.FundTransferRequestModel;
import com.alliance.util.HibernateUtil;

public class FundTransferRequestDAO 
{
	public boolean requestSent(FundTransferRequestModel fTrRequestModel)
	{
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(fTrRequestModel);
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