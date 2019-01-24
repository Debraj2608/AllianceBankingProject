package com.alliance.bo;

import java.util.List;

import com.alliance.dao.SearchDAO;
import com.alliance.model.UserModel;

public class SearchBO 
{
	public List<UserModel> getUserList(String stype, String user) 
	{
		SearchDAO sd = new SearchDAO();
		List<UserModel> lum= sd.getUserList(stype,user);
		return lum;
	}
}