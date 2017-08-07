package bank.factories;

import cs525.mum.dto.AccountDTO;
import cs525.mum.entities.Account;
import cs525.mum.factories.IAccountFactory;
import bank.entities.Checking;
import bank.entities.Saving;

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
