package main.java.cs525.mum.factories;

import main.java.cs525.mum.dto.TransactionDTO;
import main.java.cs525.mum.entities.Transaction;

public interface ITransactionFactory extends IFactory<TransactionDTO, Transaction> {
	@Override
	public Transaction create(TransactionDTO dto);
}
