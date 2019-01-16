package com.alliance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.alliance.model.FundTransferRequestModel;
import com.alliance.util.HibernateUtil;

public class AdminFundTransferActivationDAO 
{
	public List<FundTransferRequestModel> unapprovedList()
	{
		List<FundTransferRequestModel> unapprovedList = new ArrayList<FundTransferRequestModel>();
		Session session = HibernateUtil.getSessionFactory();
		unapprovedList = session.createQuery("from FundTransferRequestModel where status = "+false).list();
		return unapprovedList;
	}
}