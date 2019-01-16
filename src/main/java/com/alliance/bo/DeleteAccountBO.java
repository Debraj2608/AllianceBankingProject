package com.alliance.bo;

import com.alliance.dao.DeleteAccountDAO;
import com.alliance.model.UserModel;

public class DeleteAccountBO 
{
	DeleteAccountDAO deleteAccDAO = new DeleteAccountDAO();
	public boolean deleteAccount(UserModel model)
	{
		boolean status = deleteAccDAO.deleteAccount(model);
		return status;
		
	}
}
