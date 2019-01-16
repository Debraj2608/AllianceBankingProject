package com.alliance.bo;

import com.alliance.dao.ProfileUpdateDAO;
import com.alliance.dao.UpdatePageRedirectDAO;
import com.alliance.model.UserModel;

public class UpdatePageRedirectBO {
	public UserModel initialize(String customerID) {
		UpdatePageRedirectDAO uprdao=new UpdatePageRedirectDAO();
		UserModel um=uprdao.initialize(customerID);
		return um;

	}
}
