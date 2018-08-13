package com.cg.pwa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.cg.pwa.beans.Transaction;
import com.cg.pwa.beans.Wallet;
import com.cg.pwa.excep.TransactionException;

public class WalletDaoImpl implements WalletDao {
	
	Map<String,Wallet> data=new HashMap<>();
	Map<Long,Transaction> data1=new HashMap<>();
	
	
	@Override
	public void createaccount(Wallet w) throws TransactionException {
		data.put(w.getMobileNo(), w);

	}

	@Override
	public double showbalance(String mobile,String password) throws TransactionException {
		Wallet w=data.get(mobile);
		if(data.containsKey(mobile) && !w.getPassword().equals(password)){
			throw new TransactionException("Invalid password");
		}
		else if(data.containsKey(mobile) && w.getPassword().equals(password)){
			
			double amt=w.getBalance();
			return amt;
		}
		else{
			throw new TransactionException("mobile num not registered");
		}
	}

	@Override
	public double deposit(double amount,String mobile,String password) throws TransactionException {
		Wallet w=data.get(mobile);
		if(data.containsKey(mobile) && !w.getPassword().equals(password)){
			throw new TransactionException("Invalid password");
		}
		
		else if(data.containsKey(mobile) && w.getPassword().equals(password)){
			
			double newbal=w.getBalance()+amount;
			w.setBalance(newbal);
			data.put(w.getMobileNo(), w);
			return newbal;
		}
		else{
			throw new TransactionException("mobile num not registered");
		}
		
	}

	@Override
	public void withdraw(double amount,String mobile,String password) throws TransactionException {
		Wallet w=data.get(mobile);
		if(!data.containsKey(mobile) ){
			throw new TransactionException("mobile num not registered");
		}
		
		else if(data.containsKey(mobile) && !w.getPassword().equals(password)){
			throw new TransactionException("Invalid password");
		}
		
		else if(data.containsKey(mobile) & w.getBalance()>amount){
			//Wallet w1=data.get(mobile);
			if(w.getBalance()>amount){
			double newbal=w.getBalance()-amount;
			w.setBalance(newbal);
			data.put(w.getMobileNo(), w);
			//return w.getBalance();
			}

		}else if(data.containsKey(mobile) & (w=data.get(mobile)).getBalance()<amount){
			throw new TransactionException("Insufficient balance");
		}
		//else 
	}

	@Override
	public boolean fundtransfer(String from_mob,String to_mob,double amount) throws TransactionException {
		Transaction t=new Transaction(from_mob, to_mob, amount);
		Wallet w1;
	
		if(from_mob.equals(to_mob)){throw new TransactionException("Invalid input");}
		
		else if(data.containsKey(from_mob) & data.containsKey(to_mob) & (w1=data.get(from_mob)).getBalance()<amount){
			throw new TransactionException("Insufficient balance");
		}
		
		else if(data.containsKey(from_mob) & data.containsKey(to_mob) & (w1=data.get(from_mob)).getBalance()>amount ){
			//Wallet w1=data.get(from_mob);
			Wallet w2=data.get(to_mob);
			if(w1.getBalance()>amount){
			double amt1=w1.getBalance()-amount;
			double amt2=w2.getBalance()+amount;
			w1.setBalance(amt1);
			w2.setBalance(amt2);
			data.put(w1.getMobileNo(), w1);
			data.put(w2.getMobileNo(), w2);}
			data1.put(t.getTrans_id(), t);
			return true;
			}
		else{
		throw new TransactionException("mobile nums not found or Insufficient amount");
	}
	}
	@Override
	public List<Transaction> printtransaction() {
		List<Transaction> plist=new ArrayList<>();
		for(Long k:data1.keySet()){
			plist.add(data1.get(k));
		}
		
		return plist;
	}

	/*@Override
	public long inserttrans_details(Transaction t) {
		data1.put(t.getTrans_id(), t);
		return t.getTrans_id();
		
	}*/
	
	public List<Transaction> mytransaction(String mobileno){
		List<Transaction> mlist=new ArrayList<>();
		for(Transaction t:data1.values()){
			if(t.getFrom_mobile().equals(mobileno) | t.getTo_mobile().equals(mobileno)){
			mlist.add(t);
			}
		}
	return mlist;
}

}
