package main.java.credit.factories;

import main.java.cs525.mum.dto.ReportDTO;
import main.java.cs525.mum.factories.IReportFactory;
import main.java.cs525.mum.services.Report;
import main.java.credit.services.MonthlyBillingReport;

public class ReportFactory implements IReportFactory {

	@Override
	public Report create(ReportDTO dto) {
		Report report = null;
		switch (dto.getType()) {
		case "Monthly":
			report = new MonthlyBillingReport(dto.getFilter());
			break;
		}
		return report;
	}

}
