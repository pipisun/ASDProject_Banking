package main.java.bank.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.cs525.mum.dto.PartyDTO;
import main.java.cs525.mum.entities.Party;
import main.java.cs525.mum.services.AbstractPartyService;
import main.java.bank.dal.PartyDAOImp;
import main.java.bank.factories.PartyFactory;
import main.java.bank.util.DTOConverterUtil;

public class PartyServiceImp extends AbstractPartyService {


	private static PartyServiceImp instance;
	
	private PartyServiceImp(){
		super(new PartyDAOImp(), new PartyFactory());
	}
	
	public static PartyServiceImp getInstance() {
		if (instance == null) {
			synchronized (PartyServiceImp.class) {
				if (instance == null)
					instance = new PartyServiceImp();
			}
		}
		return instance;
	}

	@Override
	public List<PartyDTO> getAllParties() {
		List<PartyDTO> resList = new ArrayList<PartyDTO>();
		List<Party> accounts = partyDAO.getAll();
		Iterator<Party> iterator = accounts.iterator();
		while (iterator.hasNext()) {
			Party cust = iterator.next();
			PartyDTO pp = DTOConverterUtil.getPojoFromParty(cust);
			resList.add(pp);
		}
		return resList;
	}

}
