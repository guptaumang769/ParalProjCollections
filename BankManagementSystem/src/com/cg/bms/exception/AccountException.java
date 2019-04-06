package com.cg.bms.exception;

public class AccountException extends Exception{

	private static final long serialVersionUID = 1L;
	String msg;

	public AccountException(String msg) {
		super();
		this.msg = msg;
	}
}
