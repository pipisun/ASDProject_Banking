package main.java.cs525.mum.services;

import java.util.List;

import main.java.cs525.mum.dto.PartyDTO;
import main.java.cs525.mum.entities.Party;

public interface PartyService {

	public boolean saveParty(PartyDTO dto); // add party to database (Person or
											// Company)

	Party findParty(String email);

	public List<PartyDTO> getAllParties();
}
