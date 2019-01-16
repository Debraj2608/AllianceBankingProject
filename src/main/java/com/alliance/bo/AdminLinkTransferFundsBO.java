package com.alliance.bo;

import com.alliance.dao.AdminLinkTransferFundsDAO;

public class AdminLinkTransferFundsBO 
{
	AdminLinkTransferFundsDAO adLinkTrFundsDAO = new AdminLinkTransferFundsDAO();
	public boolean activate(String customerID)
	{
		boolean status = adLinkTrFundsDAO.activate(customerID);
		return status;
	}
	
}
