package main.java.cs525.mum.commands;

import framework.command.Command;
import main.java.cs525.mum.services.AbstractPartyService;

public abstract class AbstractPartyCommand  implements Command {

	protected AbstractPartyService serviceP;
	
	public AbstractPartyCommand(AbstractPartyService serviceP) {
		super();
		this.serviceP = serviceP;
	}

	@Override
	public abstract void execute();

}
