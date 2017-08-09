package main.java.cs525.mum.dto;

import framework.iterator.AbstractIterator;
import framework.iterator.AbstractObjectList;
import framework.state.AccountState;
import framework.visitor.Elements;
import main.java.cs525.mum.entities.Account;
import main.java.cs525.mum.entities.Party;

import java.util.List;

public abstract class AccountDTO implements IDTO,Elements {
	private String accountNumber;//account number
	private double interest;
	private double balance;
	private double interestRate;
	private String type;
	private Party party;


	public AccountDTO() {
	}
	public AccountDTO(AccountDTO dto) {
		this.accountNumber = dto.getAccountNumber();
		this.type = dto.getType();
		this.interestRate = dto.getInterestRate();
		this.interest = dto.getInterest();
		this.party = dto.getParty();
		this.balance = dto.getBalance();
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}

}
