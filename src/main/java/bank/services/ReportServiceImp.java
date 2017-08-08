package main.java.bank.services;

import main.java.cs525.mum.dto.ReportDTO;
import main.java.cs525.mum.services.Report;
import main.java.cs525.mum.services.ReportService;
import main.java.bank.factories.ReportFactory;

public class ReportServiceImp implements ReportService {

	
	private static ReportServiceImp instance;
	private ReportFactory factory;
	
	private ReportServiceImp(){
		factory = new ReportFactory();
	}
	
	public static ReportService getInstance(){
		if(instance == null)
			instance = new ReportServiceImp();
		return instance;
	}

	@Override
	public Report createReport(ReportDTO dto) {
		return factory.create(dto);
	}

}
