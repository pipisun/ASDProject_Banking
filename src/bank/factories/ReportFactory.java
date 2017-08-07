package bank.factories;

import cs525.mum.dto.ReportDTO;
import cs525.mum.factories.IReportFactory;
import cs525.mum.services.Report;
import bank.services.TransactionReport;

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
