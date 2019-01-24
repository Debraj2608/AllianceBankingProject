package com.alliance.bo;

import com.alliance.dao.GetBranchCodeDAO;
import com.alliance.model.UserModel;

public class GetBranchCodeBO 
{
	GetBranchCodeDAO getBranchCodeDAO = new GetBranchCodeDAO();
	public String getBranchCode(UserModel userModel)
	{
		String branchCode = getBranchCodeDAO.getBranchCode(userModel);
		return branchCode;
	}
}
