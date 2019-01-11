package com.alliance.bo;

import java.util.ArrayList;
import java.util.List;

import com.alliance.dao.AdminDispDAO;
import com.alliance.model.UserModel;

public class AdminDispBO {
	
	public List<UserModel> returnUnapproved()
	{
		AdminDispDAO add=new AdminDispDAO();
		List<UserModel> as=new ArrayList<UserModel>();
		
		as=add.returnUnapproved();
		return as;
		
	}

}
