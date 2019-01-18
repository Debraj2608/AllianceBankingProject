package com.alliance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.FundTransferRequestModel;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class AdminFundTransferActivationDAO 
{
	public List<FundTransferRequestModel> unapprovedList()
	{
		List<FundTransferRequestModel> unapprovedList = new ArrayList<FundTransferRequestModel>();
		List<FundTransferRequestModel> returnList = new ArrayList<FundTransferRequestModel>();
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			unapprovedList = session.createQuery("from FundTransferRequestModel where status = "+false).list();
			for(FundTransferRequestModel l:unapprovedList) 
			{
				String userID = l.getUserModel().getCustomerID();
				UserModel user = session.get(UserModel.class, userID);
				if(user.getAccountModel().getAccount_no()!=null)
				{
					returnList.add(l);
				}
			}
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
		return returnList;
	}
}