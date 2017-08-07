package credit.entities;

import java.time.LocalDate;

import cs525.mum.entities.Transaction;

public class PaymentTransaction extends Transaction {

	public PaymentTransaction(LocalDate date, double amount) {
		super(date, amount);
	}

	@Override
	public String getType() {
		return "Payment";
	}

}
