package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.FundTransferRequestModel;
import com.alliance.util.HibernateUtil;

public class FundTransferRequestDAO 
{
	public int requestSent(FundTransferRequestModel fTrRequestModel)
	{
		int i = 0;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			if(fTrRequestModel.getUserModel().getAccountModel()!=null)
			{
				session.save(fTrRequestModel);
				tx.commit();
				i = 1;
			}
			else
			{
				i = 2;
			}
		}
		catch(Exception e)
		{
			tx.rollback();
			i = 0;
			System.out.println(e);
		}
		finally
		{
			session.close();
		}
		//System.out.println(i+"DAO");
		return i;
	}
}