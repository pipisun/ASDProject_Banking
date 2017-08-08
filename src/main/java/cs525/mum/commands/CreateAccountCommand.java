package main.java.cs525.mum.commands;

import main.java.cs525.mum.dto.AccountDTO;
import main.java.cs525.mum.services.AbstractAccountService;

public class CreateAccountCommand extends AbstractAccountCommand {

	private AccountDTO dto;
	
	public CreateAccountCommand(AbstractAccountService serviceA, AccountDTO dto) {
		super(serviceA);
		this.dto = dto;
	}

	@Override
	public void execute() {
		//here call the service layer to save
	       if (!serviceA.saveAccount(dto))  //update the UI if the save success 
	    	   throw new RuntimeException();
	}
	
}
