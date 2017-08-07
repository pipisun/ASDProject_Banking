package bank.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.framework.controller.UserManagmentImp;
import com.cs.framework.model.abstraction.AbstractUser;
import com.cs.framework.model.concrete.Users;

import cs525.mum.dto.PartyDTO;
import cs525.mum.ui.CustomerBasePanel;
import bank.services.PartyServiceImp;

public class UserPanel extends CustomerBasePanel {
	private final static String[] columnNames = new String[] { "User Id", "Name", "Gender", "Email",
			"Zip code" };

	public UserPanel() {
		super(columnNames);
	}

	@Override
	public void displayCustomerList() {
		List<AbstractUser> userList = UserManagmentImp.getInstance().searchUser(new HashMap());
		if (userList != null) {
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int i = 0; i < userList.size(); i++) {
				Users user = (Users)userList.get(i);
				if (user != null) {
					rowdata[0] = user.getUserid();
					rowdata[1] = user.getFullname();
					rowdata[2] = user.getGender();
					rowdata[3] = user.getEmail();
					rowdata[4] = user.getZipcode();
					//rowdata[5] = user.get != null ? user.getBirthDate().toString() : "";
					//rowdata[6] = user.getNumberOfEmployees();
					model.addRow(rowdata);
				}
			}
		}
	}

	@Override
	public void JButtonPerCust_actionPerformed(java.awt.event.ActionEvent event) {
//		JDialog_AddCutomer pac = new JDialog_AddCutomer("P");
//		pac.setBounds(350, 20, 500, 600);
//		pac.show();
//
//		if (pac.isAddNew()) {
//			displayCustomerList();
//			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
//		}
	}

	@Override
	public void JButtonCompCust_actionPerformed(java.awt.event.ActionEvent event) {

//		JDialog_AddCutomer pac = new JDialog_AddCutomer("C");
//		pac.setBounds(350, 20, 300, 300);
//		pac.show();
//
//		if (pac.isAddNew()) {
//			displayCustomerList();
//			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
//		}
	}

	@Override
	public void setButtonNames() {
//		JButton_CompanyCustomer.setText("Add Company Customer");
//		JButton_PersonCustomer.setText("Add Person Customer");
	}
}
