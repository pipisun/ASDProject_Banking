package credit.entities;

import java.time.LocalDate;

import cs525.mum.entities.Transaction;

public class ChargeTransaction extends Transaction {

	public ChargeTransaction(LocalDate date, double amount) {
		super(date, amount);
	}

	@Override
	public String getType() {
		return "Charge";
	}

}
