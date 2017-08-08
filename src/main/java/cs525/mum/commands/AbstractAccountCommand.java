package main.java.cs525.mum.commands;

import main.java.cs525.mum.services.AbstractAccountService;

public abstract class AbstractAccountCommand implements Command {

	protected AbstractAccountService serviceA;
	
	public AbstractAccountCommand(AbstractAccountService serviceA) {
		super();
		this.serviceA = serviceA;
	}

	@Override
	public abstract void execute();

}
