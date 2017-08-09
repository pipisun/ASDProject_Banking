package main.java.bank.ui;

import java.util.List;

import main.java.cs525.mum.dto.PartyDTO;
import main.java.cs525.mum.ui.CustomerBasePanel;
import main.java.bank.services.PartyServiceImp;

public class CustomerPanel extends CustomerBasePanel {
	private final static String[] columnNames = new String[] { "Customer No", "Customer Name", "City", "Customer Type", "Email",
			"DOB", "Number of Employee" };

	public CustomerPanel() {
		super(columnNames);
	}

	@Override
	public void displayCustomerList() {
		List<PartyDTO> custList = PartyServiceImp.getInstance().getAllParties();
		if (custList != null) {
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int i = 0; i < custList.size(); i++) {
				PartyDTO obj = custList.get(i);
				if (obj != null) {
					rowdata[0] = obj.getId();
					rowdata[1] = obj.getName();
					rowdata[2] = obj.getCity();
					rowdata[3] = obj.getType();
					rowdata[4] = obj.getEmail();
					rowdata[5] = obj.getBirthDate() != null ? obj.getBirthDate().toString() : "";
					rowdata[6] = obj.getNumberOfEmployees();
					model.addRow(rowdata);
				}
			}
		}
	}

	@Override
	public void JButtonPerCust_actionPerformed(java.awt.event.ActionEvent event) {

	}

	@Override
	public void JButtonCompCust_actionPerformed(java.awt.event.ActionEvent event) {

	}

	@Override
	public void setButtonNames() {

	}
}
