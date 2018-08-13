package com.cg.pwa.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.pwa.beans.Transaction;
import com.cg.pwa.beans.Wallet;
import com.cg.pwa.excep.TransactionException;
import com.cg.pwa.service.WalletService;
import com.cg.pwa.service.WalletServiceImpl;

public class UserMainUI {
	
	public static void main(String[] args){
		
		WalletService wser=new WalletServiceImpl();
		Scanner sc=new Scanner(System.in);
		Wallet w;
		
		do{
			System.out.println();
			System.out.println("**********************************");
			System.out.println("Welcome to Wallet Application");
			System.out.println("Menu");
			System.out.println("1. Create Wallet");
			System.out.println("2. Show Balance ");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transactions");
			System.out.println("7. Print My Transaction");
			System.out.println("8. Exit");
			System.out.println("**********************************");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			
			switch(ch){
			
			case 1:{
				//Creating Wallet
				
				System.out.println("----Enter the following Details---");
				System.out.println("Enter the Mobileno:");
				String mob=sc.next();
				System.out.println("Enter the Customer name");
				String cust=sc.next();
				System.out.println("Enter the password");
				String password=sc.next();
				
				try {
					if(wser.validateinput(mob,cust,password)){
					w=new Wallet(mob,cust,password);
					wser.createaccount(w);
					System.out.println("Account created successfully");
				}} catch (TransactionException e) {
					System.out.println(e);
				}
				break;
			}
			
			case 2:{
				
				//To check balance in the Wallet
				
				System.out.println("Enter the Mobile no:");
				String mob=sc.next();
				System.out.println("Enter the password");
				String password=sc.next();
				
				try {
					if(mob.matches("[0-9]{10}")){
					double bal=wser.showbalance(mob,password);
					System.out.println("Your wallet balance:"+bal);
				}} catch (TransactionException e) {
					System.out.println(e);
				}
				
				break;
			}
			
			case 3:{
				
				//To deposit or add amount to the Wallet
				
				System.out.println("Enter the Mobile no:");
				String mob=sc.next();
				System.out.println("Enter the password");
				String password=sc.next();
				System.out.println("Enter the Amount:");
				double amt=sc.nextDouble();
				try {
					if(wser.validate(mob, amt)){
					double bal=wser.deposit(amt, mob,password);
					System.out.println("Your Wallet balance: "+bal);
				}} catch (TransactionException e) {
					System.out.println(e);
				}
				break;
			}
			
			case 4:{
				
				//To withdraw amount from the Wallet
				
				System.out.println("Enter the Mobile no:");
				String mob=sc.next();
				System.out.println("Enter the password");
				String password=sc.next();
				System.out.println("Enter the Amount:");
				double amt=sc.nextDouble();
				
				try {
					if(wser.validate(mob, amt)){
					wser.withdraw(amt,mob,password);
					
					//System.out.println("Your new Balance:"+bal);
				} }catch (TransactionException e) {
					System.out.println(e);
				}
				
				
				break;
			}
			case 5:{
				
				//To send or transfer money from one wallet to another
				
				System.out.println("Enter Your Mobile no: ");
				sc.nextLine();
				String mob1=sc.nextLine();
				System.out.println("Enter Mobile no you want yo transfer");
				String mob2=sc.nextLine();
				sc.nextLine();
				System.out.println("Enter the amount to transfer:");
				double amt=sc.nextDouble();
				
				try {
					boolean val=wser.fundtransfer(mob1, mob2, amt);
					if(val){
						System.out.println("successs");
						//wser.inserttrans_details(t);
					}else{
						System.out.println("Failed");
					}
				} catch (TransactionException e) {
					System.out.println(e);
				}
				
				break;
			}
			
			
			
			case 6:{
				
				//To print the transaction details
				
				List<Transaction> list=wser.printtransaction();
				for(Transaction t:list){
					System.out.println(t);
				}
				
				break;
			}
			
			case 7:{
				//print your transaction history
				System.out.println("Enter the Mobile no:");
				String mob=sc.next();
				System.out.println("Enter the password");
				String password=sc.next();
				List<Transaction> list=new ArrayList<>();
				list=wser.mytransaction(mob);//(mob, password);
				for(Transaction t:list){System.out.println(t);}
				break;
			}
			
			case 8:{
				System.out.println("Thank You for using Application");
				System.exit(0);
				break;
			}
			
			default:{
				System.out.println("Invalid choice");
				break;
			}
			}
			
		}while(true);
		
		
	}

}
