package com.alliance.bo;

import com.alliance.dao.FundTransferRequestDAO;
import com.alliance.model.FundTransferRequestModel;

public class FundTransferRequestBO 
{
	FundTransferRequestDAO fTrReqDAO = new FundTransferRequestDAO();
	public boolean requestSent(FundTransferRequestModel fTrRequestModel)
	{
		boolean status = fTrReqDAO.requestSent(fTrRequestModel);
		return status;
	}
}
