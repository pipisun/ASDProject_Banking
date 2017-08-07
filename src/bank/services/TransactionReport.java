package bank.services;

import bank.dal.AccountDAOImp;
import cs525.mum.services.Report;

public class TransactionReport extends Report {

	public TransactionReport(String filter) {
		super(new AccountDAOImp(), filter);
	}

	@Override
	public String getReport() {
		StringBuilder reportResult = new StringBuilder();
		reportResult.append("--Transaction Report--\n");
		reportResult.append("-----------------------------------------------------------------------------------------------------------\n");
		
		reportResult.append(String.format("|%12s|","No Transaction")+
		String.format("%15s|","Date")+ 
		String.format("%15s|","Ammount")+
		String.format("%15s|\n","Transaction Type"));
        reportResult.append("-----------------------------------------------------------------------------------------------------------\n");
        accountDAO.find(filter).getTransactions().forEach(s->reportResult.append(s.toString()));
		return reportResult.toString();
	}

}
