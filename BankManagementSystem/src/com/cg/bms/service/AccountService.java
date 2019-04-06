package com.cg.bms.service;

import java.util.HashMap;

import com.cg.bms.bean.*;
import com.cg.bms.exception.AccountException;

public interface AccountService {

	public boolean validateAccBal(double accBal);
	
	public Account addAccount(Account acc);
	
	public Account showAccount(long accNo)throws AccountException;
	
	public long[] showTransIDs(long accNo);
	
	public HashMap<Long,Transaction> showTransaction();
	
	public double deposit(long accNo, double amt);
	
	public double withdrawl(long accNo, double amt);
	
	public boolean transfer(long accNo1, long accNo2, double amt);
}
