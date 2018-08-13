package com.cg.pwa.excep;

public class TransactionException extends Exception {
	
	TransactionException(){
		
	}
	
	public TransactionException(String str){
		super(str);
	}

}
