package main.java.cs525.mum.factories;

import main.java.cs525.mum.dto.ReportDTO;
import main.java.cs525.mum.services.Report;

public interface IReportFactory extends IFactory<ReportDTO, Report> {
	@Override
	public Report create(ReportDTO dto);
}
