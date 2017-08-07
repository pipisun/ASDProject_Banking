package bank.entities;

import cs525.mum.entities.Account;
import cs525.mum.entities.Party;

public class Saving extends Account {

	private double interestRate;
	
	public Saving(String accountNumber, double interest, Party party, double balance) {
		super(accountNumber, interest, party, balance);		
	}

	public double getInteretRate() {
		return interestRate;
	}

	public void setInteretRate(double interetRate) {
		this.interestRate = interetRate;
	}
}
