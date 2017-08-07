package credit.factories;

import cs525.mum.dto.AccountDTO;
import cs525.mum.entities.Account;
import cs525.mum.factories.IAccountFactory;
import credit.entities.CreditCardAccount;

public class AccountFactory implements IAccountFactory {

	@Override
	public Account create(AccountDTO dto) {
		Account account = null;
		switch (dto.getType()) {
		case "G":
			account = new CreditCardAccount(dto.getAccountNumber(), CreditCardAccount.Type.GOLD.monthlyInterest, dto.getParty(),dto.getBalance(), CreditCardAccount.Type.GOLD);
			break;
		case "S":
			account = new CreditCardAccount(dto.getAccountNumber(), CreditCardAccount.Type.SILVER.monthlyInterest, dto.getParty(),dto.getBalance(),  CreditCardAccount.Type.SILVER);
			break;
		case "B":
			account = new CreditCardAccount(dto.getAccountNumber(), CreditCardAccount.Type.BRONZE.monthlyInterest, dto.getParty(),dto.getBalance(),  CreditCardAccount.Type.BRONZE);
			break;
		}
		return account;
	}

}
