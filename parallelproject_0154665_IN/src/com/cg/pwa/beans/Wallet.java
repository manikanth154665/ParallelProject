package com.cg.pwa.beans;

public class Wallet {
	private String mobileNo;
	private String password;
	private String custName;
	private double balance;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	Wallet(){
		
	}
	
	public Wallet(String mob,String name,String pwd){
		mobileNo=mob;
		custName=name;
		password=pwd;
		balance=0;
	}
	
}
