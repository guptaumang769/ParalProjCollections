package com.cg.bms.service;

import java.util.HashMap;

import com.cg.bms.Util.Util;
import com.cg.bms.bean.Account;
import com.cg.bms.bean.Transaction;
import com.cg.bms.dao.AccountDAO;
import com.cg.bms.dao.AccountDAOImpl;
import com.cg.bms.exception.AccountException;

public class AccountServiceImpl implements AccountService {

	AccountDAO dao=new AccountDAOImpl();
	
	@Override
	public boolean validateAccBal(double accBal) {
		// TODO Auto-generated method stub
		double accBalThresh = 1000;
		if(accBal<accBalThresh)
			return true;
		else
			return false;
	}

	@Override
	public Account addAccount(Account acc) {
		// TODO Auto-generated method stub
		return dao.addAccount(acc);
	}
	
	@Override
	public long[] showTransIDs(long accNo){
		return dao.showTransIDs(accNo);
	}

	@Override
	public Account showAccount(long accNo)throws AccountException{
		// TODO Auto-generated method stub
		return dao.showAccount(accNo);	
	}
	
	@Override
	public HashMap<Long,Transaction> showTransaction() {
		// TODO Auto-generated method stub
		return dao.showTransactions();
	}

	@Override
	public double deposit(long accNo, double amt) {
		// TODO Auto-generated method stub
		return dao.deposit(accNo, amt);
	}

	@Override
	public double withdrawl(long accNo, double amt){
		// TODO Auto-generated method stub
		if(amt<Util.getAccountEntries().get(accNo).getAcc_bal())
			return dao.withdrawl(accNo, amt);
		else{
			System.out.println("Transaction cannot be completed.");
			System.out.println("Insufficient Fund!!!");
			return dao.withdrawl(accNo, 0);
		}
	}

	@Override
	public boolean transfer(long accNo1, long accNo2, double amt) {
		// TODO Auto-generated method stub
		if((amt<Util.getAccountEntries().get(accNo1).getAcc_bal())&&(dao.transfer(accNo1, accNo2, amt)))
			return true;
		else{
			System.out.println("Transaction cannot be completed.");
			System.out.println("Insufficient Fund!!!");
			return false;
		}				
	}
}