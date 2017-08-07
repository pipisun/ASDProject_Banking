package cs525.mum.factories;

import cs525.mum.dto.AccountDTO;
import cs525.mum.entities.Account;


public interface IAccountFactory extends IFactory<AccountDTO, Account>{
	@Override
	public Account create(AccountDTO dto);
}