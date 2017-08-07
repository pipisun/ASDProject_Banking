package bank.entities;

import cs525.mum.entities.Account;
import cs525.mum.entities.Party;

public class Checking extends Account {

	public Checking(String accountNumber, double interest, Party party, double balance) {
		super(accountNumber, interest, party, balance);
		
	}

}
