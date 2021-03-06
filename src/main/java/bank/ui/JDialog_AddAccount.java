package main.java.bank.ui;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import framework.command.Command;
import framework.command.CommandManager;
import main.java.bank.domain.CheckingAccount;
import main.java.bank.domain.SavingAccount;
import main.java.cs525.mum.commands.CreateAccountCommand;
import main.java.cs525.mum.dto.AccountDTO;
import main.java.cs525.mum.dto.PartyDTO;
import main.java.cs525.mum.entities.Party;
import main.java.cs525.mum.ui.AddAccountDialog;
import main.java.cs525.mum.util.ValidatorUtil;
import main.java.bank.services.AccountServiceImp;
import main.java.bank.services.PartyServiceImp;

public class JDialog_AddAccount extends AddAccountDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialog_AddAccount() {
		super();
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		try {
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			Party pt = null;
			if (selection >= 0) {
				String partyId = (String) model.getValueAt(selection, 0);
				pt = PartyServiceImp.getInstance().findParty(partyId);
			} else {
				JOptionPane.showMessageDialog(this, "Please select a customer!");
				return;
			}

			isAddNew = true;
			AccountDTO pojoA = null;
			if(accType == "Saving") {
				pojoA = new SavingAccount();
			} else {
				pojoA = new CheckingAccount();
			}

			if (ValidatorUtil.isNumeric(JTextField_BALANCE.getText())) {
				pojoA.setBalance(Integer.parseInt(JTextField_BALANCE.getText()));
			} else {
				pojoA.setBalance(0);
			}
			pojoA.setType(accType);
			pojoA.setInterest(0);
			pojoA.setInterestRate(0);
			pojoA.setParty(pt);

			Command command = new CreateAccountCommand(AccountServiceImp.getInstance(), pojoA);
			CommandManager manager = CommandManager.getInstance();
			manager.setCommand(command);
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		dispose();
	}

	public boolean isAddNew() {
		return isAddNew;
	}

	@Override
	public void initial() {
		setTitle("Add Account");
		JRadioButton_First.setText("Checking");
		JRadioButton_Second.setText("Saving");
//		JRadioButton_Third.setVisible(false);
		JRadioButton_First.setSelected(true);
		JRadioButton_Second.setSelected(false);
		accType = "Checking";
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
	public void JRadioButtonFirst_mouseClicked(MouseEvent event) {
		JRadioButton_First.setSelected(true);
		JRadioButton_Second.setSelected(false);
		accType = "Checking";
	}

	@Override
	public void JRadioButtonSecond_mouseClicked(MouseEvent event) {
		JRadioButton_First.setSelected(false);
		JRadioButton_Second.setSelected(true);
		accType = "Saving";
	}

	@Override
	public void JRadioButtonThird_mouseClicked(MouseEvent event) {

	}
}
