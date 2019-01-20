package com.alliance.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alliance.dao.GetTransactionListDAO;
import com.alliance.model.TransactionModel;
import com.alliance.model.UserModel;

public class GetTransactionListBO 
{
	GetTransactionListDAO getTransactionList = new GetTransactionListDAO();
	public List<TransactionModel> transactionList(UserModel user)
	{
		List<TransactionModel> list = getTransactionList.transactionList(user);
		Collections.reverse(list);
		int size = list.size();
		System.out.println(size);
		List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		if(size>10)
		{
			int i = 1;
			for(TransactionModel tm : list)
			{	
				while(i<=10)
				{
					transactionList.add(tm);
				}
				i++;
			}
		}
		else
		{
			transactionList.addAll(list);
		}
		return transactionList;
	}
}