package main.java.cs525.mum.factories;

import main.java.cs525.mum.dto.AccountDTO;
import main.java.cs525.mum.entities.Account;
import util.framework.IFactory;


public interface IAccountFactory extends IFactory<AccountDTO, Account>{
	@Override
	public Account create(AccountDTO dto);
}