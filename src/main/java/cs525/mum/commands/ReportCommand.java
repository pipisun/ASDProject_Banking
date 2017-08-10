package main.java.cs525.mum.commands;

import framework.command.Command;
import main.java.cs525.mum.dto.ReportDTO;
import main.java.cs525.mum.services.ReportService;

public class ReportCommand implements Command {

	private ReportService service;
	private ReportDTO dto;
	private String reportResult;
	
	public ReportCommand(ReportService service, ReportDTO dto){
		this.service = service;
		this.dto = dto;
	}
	
	@Override
	public void execute() {
		reportResult = service.getReport(dto);
	}

	public String getReportResult() {
		return reportResult;
	}

}
