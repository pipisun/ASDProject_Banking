package main.java.bank.factories;

import main.java.cs525.mum.dto.ReportDTO;
import main.java.cs525.mum.factories.IReportFactory;
import main.java.cs525.mum.services.Report;
import main.java.bank.services.TransactionReport;

public class ReportFactory implements IReportFactory {

	@Override
	public Report create(ReportDTO dto) {
		Report report = null;
		switch (dto.getType()) {
		case "Transaction":
			report = new TransactionReport(dto.getFilter());
			break;
		}
		return report;
	}

}
