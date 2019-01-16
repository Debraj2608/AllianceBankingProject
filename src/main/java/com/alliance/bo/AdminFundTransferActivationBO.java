package com.alliance.bo;

import java.util.List;

import com.alliance.dao.AdminFundTransferActivationDAO;
import com.alliance.model.FundTransferRequestModel;

public class AdminFundTransferActivationBO 
{
	AdminFundTransferActivationDAO adFTrActDAO = new AdminFundTransferActivationDAO();
	public List<FundTransferRequestModel> unapprovedList()
	{
		List<FundTransferRequestModel> unapprovedList = adFTrActDAO.unapprovedList();
		
		return unapprovedList;
	}
}
