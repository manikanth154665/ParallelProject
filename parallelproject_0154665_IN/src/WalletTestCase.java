import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.pwa.beans.Wallet;
import com.cg.pwa.dao.WalletDao;
import com.cg.pwa.dao.WalletDaoImpl;
import com.cg.pwa.excep.TransactionException;
import com.cg.pwa.service.WalletService;
import com.cg.pwa.service.WalletServiceImpl;


public class WalletTestCase  {
	
	WalletService wser=new WalletServiceImpl();

	TestMethodClass test1=new TestMethodClass();
	
	Wallet w1=new Wallet("9429012744","Manikanth","mani1996");
	Wallet w2=new Wallet("7989416678","Jogi","jogi123");

	
	@Test
	public void testuserdetails() throws TransactionException {
	
		boolean expected=true;
		
		assertEquals(expected,wser.validateinput("9429012744","Manikanth","mani1996" ));
	
	}
	
	@Test
	public void testshowbalance() throws TransactionException{
		test1.createaccount(w1);
		test1.createaccount(w2);
		
		try {
			assertEquals("Invalid password",test1.showbalance("9429012744", "man1996"));
		} catch (TransactionException e) {
			System.out.println(e);
		}
		
		
	}
	
	@Test
	public void testdeposit() throws TransactionException {
		
		test1.createaccount(w1);
		test1.createaccount(w2);
		
			try {
				assertEquals("Invalid password",test1.deposit(100, "9429012744", "man1996"));
			} catch (TransactionException e) {
				System.out.println(e);
			}
			
		
		
		
	}
	
	@Test
	public void testFund() throws TransactionException {
		
		test1.createaccount(w1);
		test1.createaccount(w2);
		
		try {
			assertEquals("Invalid input",test1.fundtransfer("9429012744", "9429012744", 100));
		} catch (TransactionException e) {
			System.out.println(e);
		}
		
		
	}
public void testFund1() throws TransactionException {
		
		test1.createaccount(w1);
		test1.createaccount(w2);
		
		try {
			assertEquals("Insufficient balance",test1.fundtransfer("9429012744", "7989416678", 100));
		} catch (TransactionException e) {
			System.out.println(e);
		}
		
		
	}
	

}
