package main.java.bank.entities;

import java.time.LocalDate;

import main.java.cs525.mum.entities.Transaction;

public class WithdrawTransaction extends Transaction {

	public WithdrawTransaction(LocalDate date, double amount) {
		super(date, amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		return "Withdraw";
	}
	
	@Override
	public String toString(){
		return super.toString()+String.format("%15s|\n", getType());
	}

}
