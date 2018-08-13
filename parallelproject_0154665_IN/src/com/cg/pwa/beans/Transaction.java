package com.cg.pwa.beans;

import java.time.LocalDate;

public class Transaction {
	private long trans_id;
	private String from_mobile;
	private String to_mobile;
	private double amount;
	LocalDate trans_date;
	static long transid=123456;
	public long getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(long trans_id) {
		this.trans_id = trans_id;
	}
	public String getFrom_mobile() {
		return from_mobile;
	}
	public void setFrom_mobile(String from_mobile) {
		this.from_mobile = from_mobile;
	}
	public String getTo_mobile() {
		return to_mobile;
	}
	public void setTo_mobile(String to_mobile) {
		this.to_mobile = to_mobile;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getTrans_date() {
		return trans_date;
	}
	public void setTrans_date(LocalDate trans_date) {
		this.trans_date = trans_date;
	}
	
	Transaction(){
		trans_id=transid++;
		trans_date=LocalDate.now();
	}
	public Transaction(String from_mob,String to_mob,double amt){
		this();
		from_mobile=from_mob;
		to_mobile=to_mob;
		amount=amt;
	}
	
	public String toString(){
		return "Transaction_Id: "+trans_id+" From Mobile No: "+from_mobile+" To Mobile: "+to_mobile+" Amount: "+amount+" Transaction Date: "+trans_date;
	}

}
