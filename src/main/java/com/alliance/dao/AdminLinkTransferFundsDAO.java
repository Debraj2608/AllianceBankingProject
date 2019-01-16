package com.alliance.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.FundTransferRequestModel;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class AdminLinkTransferFundsDAO 
{
	public boolean activate(String customerID)
	{
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			UserModel user = session.get(UserModel.class, customerID);
			user.setFundsTransferStatus(true);
			List records =session.createQuery("from FundTransferRequestModel where UserModel_customerID = '"+customerID+"'").list();
			FundTransferRequestModel record = (FundTransferRequestModel) records.get(0);
			record.setStatus(true);
			record.setActivationTime(new Date());
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