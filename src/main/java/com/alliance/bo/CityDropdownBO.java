package com.alliance.bo;

import java.util.List;

import com.alliance.dao.CityDropdownDAO;
import com.alliance.model.BranchModel;

public class CityDropdownBO 
{
	CityDropdownDAO cityDropdownDAO = new CityDropdownDAO();
	public List<BranchModel> getCityList()
	{
		List<BranchModel> list = cityDropdownDAO.getCityList();
		return list;
	}
}
