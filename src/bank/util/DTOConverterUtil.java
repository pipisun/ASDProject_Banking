package bank.util;

import cs525.mum.dto.AccountDTO;
import cs525.mum.dto.PartyDTO;
import cs525.mum.entities.Account;
import cs525.mum.entities.Address;
import cs525.mum.entities.Party;
import bank.entities.Checking;
import bank.entities.Company;
import bank.entities.Person;

public class DTOConverterUtil {
	public static PartyDTO getPojoFromParty(Party party) {
		PartyDTO pp = new PartyDTO();
		pp.setId(party.getId());
		pp.setName(party.getName());
		Address address = party.getAddress();
		if (address != null) {
			pp.setStreet(address.getStreet());
			pp.setCity(address.getCity());
			pp.setState(address.getState());
			pp.setZip(address.getZip());
		}
		pp.setEmail(party.getEmail());
		if (party instanceof Person) {
			pp.setType("Person");
			pp.setBirthDate(((Person) party).getBirthDate());
		} else {
			pp.setType("Company");
			pp.setNumberOfEmployees(((Company) party).getNumberOfEmployees());
		}
		return pp;
	}

	public static AccountDTO getPojoFromAccount(Account acc) {
		AccountDTO pp = new AccountDTO();
		pp.setAccountNumber(acc.getAccountNumber());
		pp.setBalance(acc.getBalance());
		pp.setInterest(acc.getInterest());
		pp.setInterestRate(0);
		pp.setParty(acc.getParty());
		if (acc instanceof Checking) {
			pp.setType("Checking");
		} else {
			pp.setType("Saving");
		}
		return pp;
	}
}
