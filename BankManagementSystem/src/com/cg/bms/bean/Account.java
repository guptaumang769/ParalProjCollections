package com.cg.bms.bean;

import java.util.Arrays;

public class Account {

	private long acc_no;
	private String acc_holder;
	private String ifsc;
	private double acc_bal;
	private long transId[] = new long[5];
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(long acc_no, String acc_holder, String ifsc, double acc_bal) {
		super();
		this.acc_no = acc_no;
		this.acc_holder = acc_holder;
		this.ifsc = ifsc;
		this.acc_bal = acc_bal;
	}

	public long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_holder() {
		return acc_holder;
	}

	public void setAcc_holder(String acc_holder) {
		this.acc_holder = acc_holder;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public double getAcc_bal() {
		return acc_bal;
	}

	public void setAcc_bal(double acc_bal) {
		this.acc_bal = acc_bal;
	}

	public long[] getTransIds() {
		return transId;
	}

	public long getTransId(int i) {
		return transId[i];
	}
	
	public void setTransId(long tId) {
		
		System.out.println("Your Transaction Id is:"+tId);
		System.out.println();
		for(int i=this.transId.length; i>1; i--){
			this.transId[i-1] = this.transId[i-2]; 
		}
		
		this.transId[0] = tId;
	}

	@Override
	public String toString() {
		return "Account [acc_no=" + acc_no + ", acc_holder=" + acc_holder + ", ifsc=" + ifsc + ", acc_bal=" + acc_bal
				+ ", transId=" + Arrays.toString(transId) + "]";
	}
	
}