package com.alliance.bo;

import com.alliance.dao.MyAccountDAO;
import com.alliance.model.UserModel;

public class MyAccountBO 
{
	MyAccountDAO myAccountDAO = new MyAccountDAO();
	public UserModel getUpdates(String customerID)
	{
		UserModel userUpdated = myAccountDAO.getUpdates(customerID);
		return userUpdated;
	}
}
