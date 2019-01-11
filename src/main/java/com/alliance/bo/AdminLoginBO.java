package com.alliance.bo;

import com.alliance.dao.AdminLoginDAO;
import com.alliance.model.AdminModel;

public class AdminLoginBO 
{
	AdminLoginDAO adminLoginDAO = new AdminLoginDAO();
	public boolean validateAdmin(AdminModel am) 
	{
		Boolean status = false;
		 status = adminLoginDAO.validateAdmin(am);
		return status;
	}
}
