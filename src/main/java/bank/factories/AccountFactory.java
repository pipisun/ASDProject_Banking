package main.java.bank.factories;

import main.java.cs525.mum.dto.AccountDTO;
import main.java.cs525.mum.entities.Account;
import main.java.cs525.mum.factories.IAccountFactory;
import main.java.bank.entities.Checking;
import main.java.bank.entities.Saving;

public class AccountFactory implements IAccountFactory {

	@Override
	public Account create(AccountDTO dto) {
		Account account = null;
		switch (dto.getType()) {
		case "Checking":
			account = new Checking(dto.getAccountNumber(), 0, dto.getParty(),dto.getBalance());
			break;
		case "Saving":
			 account = new Saving(dto.getAccountNumber(), 0, dto.getParty(), dto.getBalance());
			break;
		}
		return account;
	}

}
