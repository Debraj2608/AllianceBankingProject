package com.alliance.bo;

import java.util.List;

import com.alliance.dao.ViewCitiesDAO;
import com.alliance.model.BranchModel;

public class ViewCitiesBO 
{
	ViewCitiesDAO viewCitiesDAO = new ViewCitiesDAO();
	public List<BranchModel> branchModelList()
	{
		List<BranchModel> list = viewCitiesDAO.branchModelList();
		return list;
	}
}
