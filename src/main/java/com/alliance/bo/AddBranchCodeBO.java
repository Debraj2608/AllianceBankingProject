package com.alliance.bo;

import com.alliance.dao.AddBranchCodeDAO;
import com.alliance.model.BranchModel;

public class AddBranchCodeBO 
{
	AddBranchCodeDAO generateBranchCodeDAO = new AddBranchCodeDAO();
	public BranchModel addBranch(BranchModel branchModel)
	{
		BranchModel details = generateBranchCodeDAO.addBranch(branchModel);
		return details; 
	}
}
