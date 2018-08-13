package com.cg.pwa.dao;

import java.util.List;

import com.cg.pwa.beans.Transaction;
import com.cg.pwa.beans.Wallet;
import com.cg.pwa.excep.TransactionException;

public interface WalletDao {
	void createaccount(Wallet w) throws TransactionException ;
	double showbalance(String mobile,String password) throws TransactionException;
	double deposit(double amount,String mobile,String password) throws TransactionException;
	void withdraw(double amount,String mobile,String password) throws TransactionException;
	boolean fundtransfer(String from_mob,String to_mob,double amount) throws TransactionException;
	List<Transaction> printtransaction();
	//long inserttrans_details(Transaction t);
	public List<Transaction> mytransaction(String mobileno);

}
