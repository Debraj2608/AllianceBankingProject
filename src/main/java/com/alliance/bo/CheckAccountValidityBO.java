package com.alliance.bo;

import com.alliance.dao.CheckAccountValidityDAO;

public class CheckAccountValidityBO 
{
	CheckAccountValidityDAO checkValidityDAO = new CheckAccountValidityDAO();
	public boolean checkValidity(String account_no)
	{
		boolean status = checkValidityDAO.checkValidity(account_no);
		return status;
	}
}
