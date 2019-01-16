package com.alliance.dao;



import com.alliance.model.UserModel;



public interface LoginDAO {
	
	public UserModel validate(UserModel um);
}
