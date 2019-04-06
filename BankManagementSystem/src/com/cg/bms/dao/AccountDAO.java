package com.cg.bms.dao;

import java.util.HashMap;

import com.cg.bms.bean.*;
import com.cg.bms.exception.AccountException;

public interface AccountDAO {

	long transID=0;
	
	public Account addAccount(Account acc);
	
	public void addTransaction(long transId, Transaction ts);
	
	public Account showAccount(long accNo)throws AccountException;
	
	public long[] showTransIDs(long accNo);
	
	public HashMap<Long,Transaction> showTransactions();
	
	public double deposit(long accNo, double amt);
	
	public double withdrawl(long accNo, double amt);
	
	public boolean transfer(long accNo1, long accNo2, double amt);
}
