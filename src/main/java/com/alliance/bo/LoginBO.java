package com.alliance.bo;


import java.sql.SQLException;

import com.alliance.dao.LoginDAO;
import com.alliance.dao.LoginDAOimpl;
import com.alliance.model.UserModel;
public class LoginBO 
{
	LoginDAO ld = new LoginDAOimpl();
	public boolean validate(UserModel lm) throws SQLException 
	{
		Boolean status = false;
		 status = ld.validate(lm);
		return status;
	}
}