package com.alliance.bo;

import java.sql.SQLException;
import java.util.List;

import com.alliance.dao.SearchDAO;
import com.alliance.model.UserModel;

public class SearchBO {
	SearchDAO sd = new SearchDAO();
	
	public List<UserModel> getUserList(String stype, String user) {
		List<UserModel> lum= sd.getUserList(stype,user);
		return lum;
	}
}
