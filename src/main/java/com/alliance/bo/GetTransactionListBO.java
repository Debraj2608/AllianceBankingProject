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
		/*for(TransactionModel m : list)
		{
			System.out.println(m.getTransaction_id()+" "+m.getTransaction_amount());
		}*/
		Collections.reverse(list);
		/*for(TransactionModel m : list)
		{
			System.out.println(m.getTransaction_id()+" "+m.getTransaction_amount());
		}*/
		int size = list.size();
		//System.out.println(size);
		List<TransactionModel> transactionList = new ArrayList<TransactionModel>();
		if(size>10)
		{
			int i = 1;
			for(TransactionModel tm : list)
			{	
				System.out.println("inside while");
				transactionList.add(tm);
				i++;
				if(i<=10)
				{
					continue;
				}
				else
				{
					break;
				}
			}
				
				
			
		}
		else
		{
			transactionList.addAll(list);
		}
		/*for(TransactionModel m : transactionList)
		{
			System.out.println(m.getTransaction_id()+" "+m.getTransaction_amount());
		}*/
		return transactionList;
	}
}