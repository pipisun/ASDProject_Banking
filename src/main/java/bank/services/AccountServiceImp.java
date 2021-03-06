package main.java.bank.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import main.java.cs525.mum.dto.AccountDTO;
import main.java.cs525.mum.entities.Account;
import main.java.cs525.mum.entities.Party;
import main.java.cs525.mum.services.AbstractAccountService;
import main.java.cs525.mum.services.NotificationService;
import main.java.bank.dal.AccountDAOImp;
import main.java.bank.entities.Company;
import main.java.bank.entities.Person;
import main.java.bank.factories.AccountFactory;
import main.java.bank.util.DTOConverterUtil;
import util.framework.AppenderLogs;
import util.framework.FileAppender;
import util.framework.FileAppenderSecurityProxy;
import util.framework.LogItem;

//Service classes are singletones
public class AccountServiceImp extends AbstractAccountService {

	private static AccountServiceImp instance;

	private AccountServiceImp(){
		super(new AccountDAOImp(), new AccountFactory());
	}

	public static AccountServiceImp getInstance() {
		if (instance == null)
			instance = new AccountServiceImp();
		return instance;
	}
	

	@Override
	public boolean deposit(String accountNumber, double amount) {
		System.out.println("Service Layer: AccountService: Inputs to deposit method " + "accountNumber ="
				+ accountNumber + ", amount= " + amount);
		super.deposit(accountNumber, amount);
		sendEmailNotification(accountNumber, amount);
		//FileAppender fileAppender = new FileAppender();
		FileAppenderSecurityProxy fileAppenderSecurityProxy = new FileAppenderSecurityProxy();
		AppenderLogs appenderLogs = new AppenderLogs();
		appenderLogs.setAppenderStrategy(fileAppenderSecurityProxy);
		String message = "Deposite Operation: Account:" + accountNumber + "   deposite amount :" + amount ;
		LogItem logItem = new LogItem(1,message,new Date());
		appenderLogs.appender(logItem);
		return true;
	}

	@Override
	public boolean wihdraw(String accountNumber, double amount) {
		System.out.println("Service Layer: AccountService: Inputs to withdraw method " + "accountNumber ="
				+ accountNumber + ", amount= " + amount);
		accountDAO.wihdrawFromAccount(accountNumber, amount); // do the deposite
		//recorder the withdraw operation in log file.
		//FileAppender fileAppender2 = new FileAppender();
		FileAppenderSecurityProxy fileAppenderSecurityProxy = new FileAppenderSecurityProxy();
		AppenderLogs appenderLogs2 = new AppenderLogs();
		appenderLogs2.setAppenderStrategy(fileAppenderSecurityProxy);
		String message = "Withdraw Operation: Account:" + accountNumber + "   withdraw amount :" + amount ;
		LogItem logItem = new LogItem(1,message,new Date());
		appenderLogs2.appender(logItem);
		sendEmailNotification(accountNumber, amount);		
		return true;// suppose withdraw done
	}

	// called from deposite and withdraw methods
	private void sendEmailNotification(String accountNumber, double amount) {
		Account account = accountDAO.find(accountNumber);
		Party party = account.getParty();

		NotificationService service = NotificationServiceImp.getInstance();
		if (party instanceof Company) {

			service.sendNotification("Wind Bank", party.getEmail(), "Transaction registered in your company", "Notification", "Mail");

		} else if (party instanceof Person) {
			if (amount > 500) {
				service.sendNotification("Wind Bank", party.getEmail(),
						"Your account register a transacction of more than 500 dollars", "Notification", "Mail");
			}
			if (account.getBalance() < 0) {
				service.sendNotification("Wind Bank", party.getEmail(), "Not enough funds", "Notification", "Mail");
			}
		}

	}
	
	public List<AccountDTO> getAllAccounts() {		
		List<AccountDTO> resList = new ArrayList<AccountDTO>();
		List<Account> accounts = accountDAO.getAll();
		Iterator<Account> iterator = accounts.iterator();
		while (iterator.hasNext()) {
			Account acc = iterator.next();
			AccountDTO pp = DTOConverterUtil.getPojoFromAccount(acc);
			resList.add(pp);
		}
		return resList;
	}
	
	@Override
	public boolean addInterest(double interest) {
		System.out.println(
				"Framework Service Layer: AbstractAccountService: Inputs to addInterestToAllAccounts method " + "interest =" + interest);
		if(accountDAO.addInterestToAllAccounts(interest))
			return true;
		return false;// suppose it success
	}

}
