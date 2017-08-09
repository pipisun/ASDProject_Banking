package main.java.bank.ui;

import java.util.List;

import javax.swing.JOptionPane;

import framework.iterator.AbstractIterator;
import framework.iterator.AbstractObjectList;
import main.java.cs525.mum.commands.Command;
import main.java.cs525.mum.commands.CommandManager;
import main.java.cs525.mum.commands.ReportCommand;
import main.java.cs525.mum.dto.AccountDTO;
import main.java.bank.services.AccountList;
import main.java.cs525.mum.dto.ReportDTO;
import main.java.cs525.mum.ui.AccountBasePanel;
import main.java.cs525.mum.ui.ReportDialog;
import main.java.bank.entities.Person;
import main.java.bank.services.AccountServiceImp;
import main.java.bank.services.ReportServiceImp;

@SuppressWarnings("serial")
public class AccountPanel extends AccountBasePanel {
	private final static String[] columnNames = new String[] { "Account No", "Account Name", "City", "Customer Type", "Account Type",
			"Amount", "Interest" };

	public AccountPanel() {
		super(columnNames);
	}

	@Override
	public void displayAccountList() {
		List<AccountDTO> custList = AccountServiceImp.getInstance().getAllAccounts();
		if (custList != null && model != null) {
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			AbstractObjectList list;
			AbstractIterator iterator;

			list = new AccountList(custList);
			iterator = list.createIterator();
			while(!iterator.isLast()) {

				AccountDTO obj = (AccountDTO)iterator.getNextItem();
				rowdata[0] = obj.getAccountNumber();
				rowdata[1] = obj.getParty().getName();
				rowdata[2] = obj.getParty().getAddress().getCity();
				if (obj.getParty() instanceof Person) {
					rowdata[3] = "Person";
				} else {
					rowdata[3] = "Company";
				}
				rowdata[4] = obj.getType();
				rowdata[5] = obj.getBalance();
				rowdata[6] = obj.getInterest();
				model.addRow(rowdata);
				iterator.next();
			}
		}
	}
	
	@Override
	public void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	@Override
	public void JButtonAddAcc_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog_AddAccount pac = new JDialog_AddAccount();
		pac.setBounds(450, 20, 500, 600);
		pac.setVisible(true);
		if (pac.isAddNew()) {
			displayAccountList();
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
	}

	@Override
	public void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			JDialog_Deposit dep = new JDialog_Deposit(accnr);
			dep.setBounds(930, 15, 375, 200);
			dep.setVisible(true);
			if (dep.isNewDeposit()) {
				displayAccountList();
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please select an account to deposit!");
		}
	}

	@Override
	public void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			Double currAmount = (Double) model.getValueAt(selection, 5);
			JDialog_Withdraw wd = new JDialog_Withdraw(accnr, currAmount);
			wd.setBounds(430, 15, 375, 200);
			wd.setVisible(true);
			if (wd.isNewWithdraw()) {
				displayAccountList();
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please select an account to withdraw!");
		}
	}

	@Override
	public void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog_AddInterest wd = new JDialog_AddInterest();
		wd.setBounds(300, 25, 375, 200);
		wd.setVisible(true);
		displayAccountList();
	}

	@Override
	public void JButtonReport_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			ReportDTO dto = new ReportDTO();
			dto.setFilter(accnr);
			dto.setType("Transaction");
			Command command = new ReportCommand(ReportServiceImp.getInstance(), dto);
			CommandManager manager = CommandManager.getInstance();
			manager.setCommand(command);
			manager.invokeCommand();
			String tmpStr = ((ReportCommand) command).getReportResult();
			ReportDialog re = new ReportDialog(tmpStr, this);
			re.setBounds(200, 50, 600, 400);
			this.setVisible(false);
			re.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Please select an account to make the report!");
		}
	}

	@Override
	public void setButtonNames() {
		JButton_Deposit.setText("Deposit");
		JButton_Exit.setText("Exit");
		JButton_Report.setText("Report");
		JButton_Withdraw.setText("Withdraw");
	}

}
