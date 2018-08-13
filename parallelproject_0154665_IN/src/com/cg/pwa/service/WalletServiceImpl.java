package com.cg.pwa.service;

import java.util.List;









import com.cg.pwa.beans.Transaction;
import com.cg.pwa.beans.Wallet;
import com.cg.pwa.dao.WalletDao;
import com.cg.pwa.dao.WalletDaoImpl;
import com.cg.pwa.dao.WalletDaoImpl1;
import com.cg.pwa.excep.TransactionException;

public class WalletServiceImpl implements WalletService {
	
	WalletDao wdao=new WalletDaoImpl();

	
	@Override
	public void createaccount(Wallet w) throws TransactionException {
		 wdao.createaccount(w);
	}

	@Override
	public double showbalance(String mobile,String password) throws TransactionException {
		return wdao.showbalance(mobile,password);
	}

	@Override
	public double deposit(double amount,String mobile,String password) throws TransactionException {
		return wdao.deposit(amount,mobile,password);
	}

	@Override
	public void withdraw(double amount,String mobile,String password) throws TransactionException {
		 wdao.withdraw(amount,mobile,password);
	}

	@Override
	public boolean fundtransfer(String from_mob,String to_mob,double amount) throws TransactionException{
		
		return wdao.fundtransfer(from_mob, to_mob, amount);
	}

	@Override
	public List<Transaction> printtransaction() {
		return wdao.printtransaction();
	}

	/*@Override
	public long inserttrans_details(Transaction t) {
		
		return wdao.inserttrans_details(t);
	}*/

	@Override
	public boolean validateinput(String mob,String name,String password) throws TransactionException {
		if(!mob.matches("[0-9]{10}")){
			throw new TransactionException("Mobile must be of length 10 and doesnot contain characters");
			
		}
		if(!name.matches("[A-Z][a-z]{3,20}")){
			throw new TransactionException("Customer name must start with uppercase followed by lowercase");
		}
		
		/*if(!password.matches("[a-z]")){
			throw new TransactionException("password must start with lowercase letter followed by numbers");
		}*/
		
		return true;
		
	}

	@Override
	public boolean validate(String mobile, double amount) throws TransactionException {
		if(!mobile.matches("[0-9]{10}")){
			throw new TransactionException("Mobile must should be of length 10");
			
		}
		if(amount<=0){
			throw new TransactionException("Enter the valid amount");
		}
		return true;
	}

	@Override
	public List<Transaction> mytransaction(String mobileno) {
		return wdao.mytransaction(mobileno);
	}
	
	

	

}
