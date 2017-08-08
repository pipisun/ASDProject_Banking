package main.java.cs525.mum.dal;

import main.java.cs525.mum.entities.Account;
import main.java.cs525.mum.entities.Transaction;

public interface AccountDAO extends IDAO<Account>{
	
	boolean depositToAccount(String accountNumber, double amount);
	
	boolean wihdrawFromAccount(String accountNumber, double amount);
	
	boolean addInterest(String accountNumber, double interest);//add interest to specific account. TODO: is the signature is correct
	
	boolean addTransacionToAccount(String accountNumber, Transaction transaction);
	
	boolean addInterestToAllAccounts(double interest);

}
