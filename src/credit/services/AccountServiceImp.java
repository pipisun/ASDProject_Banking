package credit.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs525.mum.dto.AccountDTO;
import cs525.mum.entities.Account;
import cs525.mum.entities.Party;
import cs525.mum.services.AbstractAccountService;
import cs525.mum.services.NotificationService;
import credit.dal.AccountDAOImp;
import credit.entities.Company;
import credit.entities.Person;
import credit.factories.AccountFactory;
import credit.util.DTOConverterUtil;

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
		return true;
	}

	@Override
	public boolean wihdraw(String accountNumber, double amount) {
		System.out.println("Service Layer: AccountService: Inputs to withdraw method " + "accountNumber ="
				+ accountNumber + ", amount= " + amount);
		accountDAO.wihdrawFromAccount(accountNumber, amount); // do the deposite
		sendEmailNotification(accountNumber, amount);		
		return true;// suppose withdraw done
	}

	// called from deposite and withdraw methods
	private void sendEmailNotification(String accountNumber, double amount) {
		Account account = accountDAO.find(accountNumber);
		Party party = account.getParty();

		NotificationService service = NotificationServiceImp.getInstance();
		if (party instanceof Company) {

			service.sendNotification("Wind Bank", party.getEmail(), "Some Message", "Notification", "Mail");

		} else if (party instanceof Person) {
			if (amount > 400) {
				service.sendNotification("Wind Bank", party.getEmail(),
						"Your account register a transacction of more than 400 dollars", "Notification", "Mail");
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
	
	public boolean addInterest(double interest) {
		return false;// suppose it success
	}

}
