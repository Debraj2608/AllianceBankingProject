package com.alliance.bo;

import com.alliance.dao.AdminLinkDAO;
import com.alliance.model.AccountModel;
import com.alliance.model.UserModel;

public class AdminLinkBO 
{
	AdminLinkDAO adminLinkDAO = new AdminLinkDAO();
	public boolean insertDetails(AccountModel accountModel,UserModel userModel)
	{
		boolean status = adminLinkDAO.insertDetails(accountModel, userModel);
		return status;
	}
}
