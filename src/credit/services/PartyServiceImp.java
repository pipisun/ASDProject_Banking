package credit.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs525.mum.dto.PartyDTO;
import cs525.mum.entities.Party;
import cs525.mum.services.AbstractPartyService;
import credit.dal.PartyDAOImp;
import credit.factories.PartyFactory;
import credit.util.DTOConverterUtil;

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
