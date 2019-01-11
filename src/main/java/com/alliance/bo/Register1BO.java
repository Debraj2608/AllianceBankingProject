package com.alliance.bo;

import com.alliance.dao.Register1DAOimpl;
import com.alliance.model.UserModel;

public class Register1BO 
{
	Register1DAOimpl register1DAOimpl = new Register1DAOimpl();
	public boolean register1validate(UserModel userModel)
	{
		boolean status = register1DAOimpl.validate1Register(userModel);
		return status;
	}
}
