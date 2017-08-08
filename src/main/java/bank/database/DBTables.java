package main.java.bank.database;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.bank.entities.Checking;
import main.java.bank.entities.Company;
import main.java.bank.entities.DepositTransaction;
import main.java.bank.entities.Person;
//This class represents a database. Each list represent a table
import main.java.bank.entities.Saving;
import main.java.bank.entities.WithdrawTransaction;
import main.java.cs525.mum.entities.Account;
import main.java.cs525.mum.entities.Address;
import main.java.cs525.mum.entities.Party;
import main.java.cs525.mum.entities.Transaction;

public class DBTables {
	
	
	public static List<Account> ACCOUNT_TABLE = new ArrayList<Account>(); //TODO: make it as List<Account> and add default accounts
	
	public static List<Party> Party_TABLE = new ArrayList<Party>(); 
	
	static {
		//String name, Address address, String email, int numberOfEmployees
		//String street, String city, String state, String zip
		//Checking String accountNumber, double interest, Party party, double balance
		//Saving String accountNumber, double interest, Party party, double balanc
		Party c1 = new Company("Walmart", new Address("49 E Whashinton","Mountain View","CA","89745"),"Walmart@walmart.com",10000);
		c1.setId("1000001");
		Party c2 = new Company("State Grid", new Address("63 W Meridi","Los Gatos","CA","89745"),"StateGrid@stategrid.com",18000);
		c2.setId("1000002");
		Party c3 = new Company("Royal Dutch Shell", new Address("Mond W 46","Seattle","CA","89745"),"Royal@royal.com",10800);
		c3.setId("1000003");
		Party c4 = new Company("Volkswagen", new Address("NA","Southland","CA","89745"),"volkswagen@volkswagen.com",16000);
		c4.setId("1000004");
		
		Party p1 = new Person("Bo Liu",new Address("405 E Street 1","Chicago","IL","56899"),"poliu@gmail.com", LocalDate.of(1996, 2, 27));
		p1.setId("2000001");
		Party p2 = new Person("Ming Li",new Address("158 W Avenue","Miami","FL","56899"),"mingli@gmail.com", LocalDate.of(1983, 10, 14));
		p2.setId("2000002");
		Party p3 = new Person("Lin Chen",new Address("791 E Ttee","Sillicon Valley","NA","56899"),"linchen@gmail.com", LocalDate.of(1993, 2, 27));
		p3.setId("3000001");
		Party p4 = new Person("James Zuckerber",new Address("31450 Trer 8","Northland","NA","56899"),"james@gmail.com", LocalDate.of(1999, 2, 27));
		p4.setId("4000004");
		
		Party_TABLE.add(c1);
		Party_TABLE.add(c2);
		Party_TABLE.add(c3);
		Party_TABLE.add(c4);
		
		Party_TABLE.add(p1);
		Party_TABLE.add(p2);
		Party_TABLE.add(p3);
		Party_TABLE.add(p4);
		
		Account ac1 = new Checking("100001",0,c1,5000);
		Transaction t1 = new DepositTransaction(LocalDate.of(2015, 12, 30),1000);
		t1.setNumber("1");
		ac1.addTransaction(t1);
		Transaction t2 = new WithdrawTransaction(LocalDate.now(),500);
		t2.setNumber("2");
		ac1.addTransaction(t2);
		
		ACCOUNT_TABLE.add(ac1);
		ACCOUNT_TABLE.add(new Saving("100002",0,c1,800000));
		ACCOUNT_TABLE.add(new Checking("200111",0,c2,4000));
		ACCOUNT_TABLE.add(new Saving("200212",0,c2,900000));
		ACCOUNT_TABLE.add(new Checking("300001",0,c3,6000));
		ACCOUNT_TABLE.add(new Saving("300002",0,c3,100000));
		ACCOUNT_TABLE.add(new Checking("400001",0,c4,66000));

		Account ac2 = new Saving("500002",0,p1,800000);
		 t2 = new  DepositTransaction(LocalDate.of(2015, 11, 30),15000);
		t2.setNumber("3");
		ac2.addTransaction(t2);
		t2 = new WithdrawTransaction(LocalDate.now(),50000);
	    t2.setNumber("4");
		ac2.addTransaction(t2);
		
		ACCOUNT_TABLE.add(new Checking("500001",0,p1,5000));
		ACCOUNT_TABLE.add(ac2);
		ACCOUNT_TABLE.add(new Checking("600001",0,p2,4000));
		ACCOUNT_TABLE.add(new Saving("600002",0,p2,900000));
		ACCOUNT_TABLE.add(new Checking("700001",0,p3,6000));
		ACCOUNT_TABLE.add(new Saving("700002",0,p3,100000));
		ACCOUNT_TABLE.add(new Checking("800001",0,p4,66000));
	}
	
	private DBTables(){	}
	
	

}
