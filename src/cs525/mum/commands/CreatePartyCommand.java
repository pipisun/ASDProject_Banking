package cs525.mum.commands;

import cs525.mum.dto.PartyDTO;
import cs525.mum.services.AbstractPartyService;

public class CreatePartyCommand extends AbstractPartyCommand {
	
	private PartyDTO dto;

	public CreatePartyCommand(AbstractPartyService serviceP, PartyDTO dto) {
		super(serviceP);
		this.dto = dto;
	}

	@Override
	public void execute() throws RuntimeException {
		// here call the service layer to save
		if (!serviceP.saveParty(dto)) // update the UI if the save success
			throw new RuntimeException();
	}
}
