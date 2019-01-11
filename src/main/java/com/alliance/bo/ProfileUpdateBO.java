package com.alliance.bo;

import com.alliance.dao.ProfileUpdateDAO;
import com.alliance.model.UserModel;

public class ProfileUpdateBO {
public boolean update(UserModel um) {
	ProfileUpdateDAO pudao=new ProfileUpdateDAO();
	boolean b=pudao.update(um);
	return b;
}
}
