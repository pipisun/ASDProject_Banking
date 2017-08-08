package main.java.cs525.mum.services;

import main.java.cs525.mum.dal.AccountDAO;

public abstract class Report {

	protected AccountDAO accountDAO;
	protected String filter;
	
	public Report(AccountDAO accountDAO, String filter){
		this.accountDAO = accountDAO;
		this.setFilter(filter);
	}
	
	public abstract String getReport();

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
}
