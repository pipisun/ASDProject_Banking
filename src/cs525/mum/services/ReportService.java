package cs525.mum.services;

import cs525.mum.dto.ReportDTO;

public interface ReportService {
	
	public default String getReport(ReportDTO dto){
		Report report = createReport(dto);
		return report.getReport();
	}
	
	public Report createReport(ReportDTO dto);
	
}
