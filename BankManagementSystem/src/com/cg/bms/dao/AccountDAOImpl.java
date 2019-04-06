package com.cg.bms.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.cg.bms.Util.Util;
import com.cg.bms.bean.Account;
import com.cg.bms.bean.Transaction;
import com.cg.bms.dao.AccountDAO;
import com.cg.bms.exception.AccountException;

public class AccountDAOImpl implements AccountDAO {

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	@Override
	public Account addAccount(Account acc) {
		// TODO Auto-generated method stub
		Util.getAccountEntries().put(acc.getAcc_no(), acc);
		return acc;
	}
	@Override
	public void addTransaction(long transId, Transaction ts) {
		// TODO Auto-generated method stub
		Util.getTransactionEntries().put(transId,ts);
	}
	@Override
	public Account showAccount(long accNo) throws AccountException{
		// TODO Auto-generated method stub
		HashMap<Long,Account> acMap = Util.getAccountEntries();
		if(acMap.size()==0)
			throw new AccountException("No employee data found");
		else
			return Util.getAccountEntries().get(accNo); 
	}
	@Override
	public long[] showTransIDs(long accNo){
		return Util.getAccountEntries().get(accNo).getTransIds();
	}
	
	@Override
	public HashMap<Long,Transaction> showTransactions(){
		// TODO Auto-generated method stub
		HashMap<Long,Transaction> tsMap = Util.getTransactionEntries();
		if(tsMap.size()==0){
			System.out.println("No Transaction history found");
			return null;
		}
		else
			return tsMap;
	}

	@Override
	public double deposit(long accNo, double amt) {
		// TODO Auto-generated method stub
		
		balInc(accNo,amt);
		Util.getAccountEntries().get(accNo).setTransId(((long)(Math.random()*1000+1)));
		LocalDateTime now = LocalDateTime.now();
		Transaction ts = new Transaction("Deposit",amt,Util.getAccountEntries().get(accNo).getAcc_bal(),dtf.format(now));
		addTransaction(Util.getAccountEntries().get(accNo).getTransId(0), ts);
		return Util.getAccountEntries().get(accNo).getAcc_bal();
	}
	
	private void balInc(long accNo, double amt){
		double balance = Util.getAccountEntries().get(accNo).getAcc_bal()+amt;
		Util.getAccountEntries().get(accNo).setAcc_bal(balance);
	}

	@Override
	public double withdrawl(long accNo, double amt) {
		// TODO Auto-generated method stub
		
		balDec(accNo,amt);
		Util.getAccountEntries().get(accNo).setTransId(((long)(Math.random()*1000+1)));
		LocalDateTime now = LocalDateTime.now();
		Transaction ts = new Transaction("withdrawl",amt,Util.getAccountEntries().get(accNo).getAcc_bal(),dtf.format(now));
		addTransaction(Util.getAccountEntries().get(accNo).getTransId(0), ts);
		return Util.getAccountEntries().get(accNo).getAcc_bal();
	}
	private void balDec(long accNo, double amt){
		double balance = Util.getAccountEntries().get(accNo).getAcc_bal()-amt;
		Util.getAccountEntries().get(accNo).setAcc_bal(balance);
	}

	@Override
	public boolean transfer(long accNo1, long accNo2, double amt) {
		// TODO Auto-generated method stub
		double bal1 = Util.getAccountEntries().get(accNo1).getAcc_bal();
		if(bal1>=amt){
			
			balDec(accNo1,amt);
			balInc(accNo2,amt);

			long tid1 = (long)(Math.random()*1000+1);
			long tid2 = (long)(Math.random()*1000+1);
			
			Util.getAccountEntries().get(accNo1).setTransId(tid1);
			LocalDateTime now = LocalDateTime.now();
			Transaction ts1 = new Transaction("Transfer",amt,Util.getAccountEntries().get(accNo1).getAcc_bal(),dtf.format(now));
			addTransaction(Util.getAccountEntries().get(accNo1).getTransId(0), ts1);
			
			Util.getAccountEntries().get(accNo2).setTransId(tid2);
			Transaction ts2 = new Transaction("Transfer",amt,Util.getAccountEntries().get(accNo2).getAcc_bal(),dtf.format(now));
			addTransaction(Util.getAccountEntries().get(accNo2).getTransId(0), ts2);
			
			return true;
		}
		else
			return false;
			
	}

}
