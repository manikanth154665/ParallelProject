package com.cg.pwa.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.cg.pwa.beans.Database;
import com.cg.pwa.beans.Transaction;
import com.cg.pwa.beans.Wallet;
import com.cg.pwa.excep.TransactionException;

public class WalletDaoImpl1 implements WalletDao {
	
	

	@Override
	public void createaccount(Wallet w) throws TransactionException {

		Connection con=Database.getconnection();
		
		String sql="insert into Wallet values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,w.getMobileNo() );
			ps.setString(2, w.getCustName());
			ps.setString(3, w.getPassword());
			ps.setDouble(4, w.getBalance());;
			
			ps.executeUpdate();
			System.out.println("1 row is inserted");
		} catch (SQLException e) {
			System.out.println("Error");
		}
		
		
	}

	@Override
	public double showbalance(String mobile, String password)
			throws TransactionException {

		return 0;
	}

	@Override
	public double deposit(double amount, String mobile, String password)
			throws TransactionException {

		return 0;
	}

	@Override
	public void withdraw(double amount, String mobile, String password)
			throws TransactionException {

		
	}

	@Override
	public boolean fundtransfer(String from_mob, String to_mob, double amount)
			throws TransactionException {

		return false;
	}

	@Override
	public List<Transaction> printtransaction() {

		return null;
	}

	@Override
	public List<Transaction> mytransaction(String mobileno) {

		return null;
	}

}
