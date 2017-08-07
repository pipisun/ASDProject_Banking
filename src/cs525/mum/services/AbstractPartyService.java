package cs525.mum.services;

import cs525.mum.dal.PartyDAO;
import cs525.mum.dto.PartyDTO;
import cs525.mum.entities.Party;
import cs525.mum.factories.IPartyFactory;

public abstract class AbstractPartyService implements PartyService {

	protected PartyDAO partyDAO;
	private IPartyFactory factory;
	
	public AbstractPartyService(PartyDAO partyDAO, IPartyFactory factory){
		if(partyDAO!=null && factory!=null){
			this.partyDAO = partyDAO;
			this.factory = factory;
		}else{
			throw new RuntimeException("Provided DAO is null");
		}
	}
	
	@Override
	public boolean saveParty(PartyDTO dto) {
		Party party = factory.create(dto);
		System.out.println(
				"Framework Service Layer: AbstractPartyService: Inputs to saveParty");
		if (partyDAO.add(party))
			return true;
		return false;
	}

	@Override
	public Party findParty(String id) {
			return partyDAO.find(id);
	}

	

}
