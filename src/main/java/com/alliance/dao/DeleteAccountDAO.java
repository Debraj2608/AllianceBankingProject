package com.alliance.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.AccountModel;
import com.alliance.model.DeletedAccountsInfoModel;
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
			DeletedAccountsInfoModel deleteAccount =  new DeletedAccountsInfoModel();
			deleteAccount.setDeletionDateInfo(new Date());
			deleteAccount.setAccountNo(model.getAccountModel().getAccount_no());
			deleteAccount.setCustomerID(model.getCustomerID());
			deleteAccount.setFirstName(model.getFirstName());
			deleteAccount.setMiddleName(model.getMiddleName());
			deleteAccount.setLastName(model.getLastName());
			session.save(deleteAccount);
			tx.commit();
			
			/*tx = session.beginTransaction();
			String accountNumber = model.getAccountModel().getAccount_no();
			AccountModel account = session.get(AccountModel.class, accountNumber);
			System.out.println(account.getAccount_no());
			session.delete(account);
			tx.commit();*/
			
			tx = session.beginTransaction();
			UserModel temp = session.get(UserModel.class, model.getCustomerID());
			System.out.println(temp.getCustomerID());
			session.delete(temp);
			tx.commit();
			
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
