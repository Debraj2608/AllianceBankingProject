package com.alliance.dao;



import com.alliance.model.UserModel;



public interface LoginDAO {
	
	public Boolean validate(UserModel lm);
}
