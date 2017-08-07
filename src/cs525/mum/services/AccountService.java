package cs525.mum.services;

import java.util.List;

import cs525.mum.dto.AccountDTO;

public interface AccountService {
	
	boolean saveAccount(AccountDTO dto);//add account to database
	
	//Account createAccount(String type); //create an instance of the an specific type of account
	
	boolean addInterest(double interest);
	
	boolean deposit(String accountNumbr, double amount);
	
	boolean wihdraw(String accountNumbr, double amount);
	
	public List<AccountDTO> getAllAccounts();

}
