package com.alliance.bo;

import com.alliance.dao.AdminLinkDAO;
import com.alliance.model.AccountModel;

public class AdminLinkBO 
{
	AdminLinkDAO adminLinkDAO = new AdminLinkDAO();
	public boolean insertDetails(AccountModel accountModel)
	{
		boolean status = adminLinkDAO.insertDetails(accountModel);
		return status;
	}
}
