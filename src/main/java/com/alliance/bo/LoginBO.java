package com.alliance.bo;


import java.sql.SQLException;

import com.alliance.dao.LoginDAO;
import com.alliance.dao.LoginDAOimpl;
import com.alliance.model.UserModel;
public class LoginBO 
{
	LoginDAO ld = new LoginDAOimpl();
	public UserModel validate(UserModel um) throws SQLException 
	{
		
		UserModel userRecord = ld.validate(um);
		return userRecord;
		
	}
}