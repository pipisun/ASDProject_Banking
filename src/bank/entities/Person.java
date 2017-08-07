package bank.entities;

import java.time.LocalDate;

import cs525.mum.entities.Address;
import cs525.mum.entities.Party;

public class Person extends Party {

	private LocalDate birthDate;
	
	public Person(String name, Address address, String email, LocalDate birthDate) {
		super(name, address, email);
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}	

}
