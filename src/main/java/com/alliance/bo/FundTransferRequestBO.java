package com.alliance.bo;

import com.alliance.dao.FundTransferRequestDAO;
import com.alliance.model.FundTransferRequestModel;

public class FundTransferRequestBO 
{
	FundTransferRequestDAO fTrReqDAO = new FundTransferRequestDAO();
	public int requestSent(FundTransferRequestModel fTrRequestModel)
	{
		int i = fTrReqDAO.requestSent(fTrRequestModel);
		return i;
	}
}
