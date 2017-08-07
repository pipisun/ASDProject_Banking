package cs525.mum.factories;

import cs525.mum.dto.ReportDTO;
import cs525.mum.services.Report;

public interface IReportFactory extends IFactory<ReportDTO, Report> {
	@Override
	public Report create(ReportDTO dto);
}
