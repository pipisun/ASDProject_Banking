package cs525.mum.factories;

import cs525.mum.dto.PartyDTO;
import cs525.mum.entities.Party;

public interface IPartyFactory extends IFactory<PartyDTO, Party>{
	@Override
	public Party create(PartyDTO dto);
}
