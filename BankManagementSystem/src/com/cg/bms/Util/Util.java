package com.cg.bms.Util;

import java.util.HashMap;

import com.cg.bms.bean.*;

public class Util {
	
	static HashMap<Long,Account> account=new HashMap<Long,Account>();
	
	static HashMap<Long,Transaction> transaction=new HashMap<Long,Transaction>();
	
	
	public static HashMap<Long,Account> getAccountEntries()
	{
		return account;
	}
	
	
	public static HashMap<Long,Transaction> getTransactionEntries()
	{
		return transaction;
	}
	
}
