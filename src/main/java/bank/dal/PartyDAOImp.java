package main.java.bank.dal;

import java.util.List;
import java.util.stream.Collectors;

import main.java.cs525.mum.dal.PartyDAO;
import main.java.cs525.mum.entities.Party;
import main.java.cs525.mum.util.GeneratorUtil;
import main.java.cs525.mum.util.SystemConstant;
import main.java.bank.database.DBTables;

public class PartyDAOImp implements PartyDAO {

	@Override
	public boolean add(Party party) {
		party.setId(GeneratorUtil.randomString(SystemConstant.RAND_LOWER, SystemConstant.RAND_HIGHER));
		DBTables.Party_TABLE.add(party);
		return true;
	}

	@Override
	public List<Party> getAll() {
		return DBTables.Party_TABLE;
	}

	@Override
	public Party find(String id) {
		List<Party> list = 
				DBTables.Party_TABLE.stream().
				filter(party -> party.getId().equals(id))
				.collect(Collectors.toList()); //should get one object
		
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	
}
