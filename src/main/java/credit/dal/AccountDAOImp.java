package main.java.credit.dal;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import main.java.cs525.mum.dal.AccountDAO;
import main.java.cs525.mum.entities.Account;
import main.java.cs525.mum.entities.Transaction;
import main.java.cs525.mum.util.GeneratorUtil;
import main.java.cs525.mum.util.SystemConstant;
import main.java.credit.database.DBTables;
import main.java.credit.entities.ChargeTransaction;
import main.java.credit.entities.PaymentTransaction;

public class AccountDAOImp implements AccountDAO {

	@Override
	public boolean add(Account account) {
		account.setAccountNumber(GeneratorUtil.randomString(SystemConstant.RAND_LOWER, SystemConstant.RAND_HIGHER));
		DBTables.ACCOUNT_TABLE.add(account);
		return true;
	}

	@Override
	public Account find(String accountNumber) {
		List<Account> list = 
				DBTables.ACCOUNT_TABLE.stream().
				filter(account -> account.getAccountNumber() == accountNumber)
				.collect(Collectors.toList()); //should get one object
		
		if (list.size() > 0)
			return list.get(0);
		
		return null;
	}

	@Override
	public List<Account> getAll() {
		return DBTables.ACCOUNT_TABLE;
	}

	@Override
	public boolean depositToAccount(String accountNumber, double amount) {
		Account accountToUpdate = find(accountNumber);
		if (accountToUpdate != null) {
			accountToUpdate.setBalance(accountToUpdate.getBalance() + amount); // TODO: test it	
			PaymentTransaction paymentTransaction = new PaymentTransaction(LocalDate.now(), amount);
			paymentTransaction.setNumber(GeneratorUtil.randomString(SystemConstant.RAND_LOWER, SystemConstant.RAND_HIGHER));
			addTransacionToAccount(accountNumber, paymentTransaction);
			return true;
		}

		return false;
	}

	@Override
	public boolean wihdrawFromAccount(String accountNumber, double amount) {
		Account accountToUpdate = find(accountNumber);
		if (accountToUpdate != null) {
			accountToUpdate.setBalance(accountToUpdate.getBalance() - amount); // TODO: test it
			ChargeTransaction chargeTransaction = new ChargeTransaction(LocalDate.now(), amount);
			chargeTransaction.setNumber(GeneratorUtil.randomString(SystemConstant.RAND_LOWER, SystemConstant.RAND_HIGHER));
			addTransacionToAccount(accountNumber, chargeTransaction);
			return true;
		}

		return false;
	}

	@Override
	public boolean addInterest(String accountNumber, double interest) {
		Account accountToUpdate = find(accountNumber);
		if (accountToUpdate != null) {
			accountToUpdate.setInterest(interest); // TODO: test it																				 
			return true;
		}

		return false;
	}

	@Override
	public boolean addTransacionToAccount(String accountNumber, Transaction transaction) {
		Account accountToUpdate = find(accountNumber);
		if (accountToUpdate != null) {
			accountToUpdate.addTransaction(transaction); // TODO: test it																				 
			return true;
		}

		return false;
	}

	@Override
	public boolean addInterestToAllAccounts(double interest) {
		List<Account> accounts = getAll();
		Iterator<Account> iterator = accounts.iterator();
		while (iterator.hasNext()) {
			Account account = iterator.next();
			account.setInterest(interest);// TODO: what about the intrest
			// If we have data base, then we should updae the interest and save
			// for each account
		}
		return true;
	}

}
