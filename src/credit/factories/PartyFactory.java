package credit.factories;

import cs525.mum.dto.PartyDTO;
import cs525.mum.entities.Address;
import cs525.mum.entities.Party;
import cs525.mum.factories.IPartyFactory;
import credit.entities.Company;
import credit.entities.Person;

public class PartyFactory implements IPartyFactory {

	@Override
	public Party create(PartyDTO dto) {
		Party client = null;
		Address address = new Address(dto.getStreet(), dto.getCity(), dto.getState(), dto.getZip());
		switch (dto.getType()) {
		case "P":
			client = new Person(dto.getName(), address, dto.getEmail(), dto.getBirthDate());
			break;
		case "C":
			 client = new Company(dto.getName(), address, dto.getEmail(), dto.getNumberOfEmployees());
			break;
		}
		return client;
	}

}
