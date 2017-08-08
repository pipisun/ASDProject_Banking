package main.java.bank.ui;

import main.java.cs525.mum.commands.Command;
import main.java.cs525.mum.commands.CommandManager;
import main.java.cs525.mum.commands.DepositComand;
import main.java.cs525.mum.ui.DepositDialog;
import main.java.cs525.mum.util.ValidatorUtil;
import main.java.bank.services.AccountServiceImp;

public class JDialog_Deposit extends DepositDialog {

	public JDialog_Deposit(String aaccnr) {
		super(aaccnr);
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		if (!ValidatorUtil.isNumeric(JTextField_Deposit.getText())) {
			isNewDeposit = false;
			dispose();
			return;
		}
		Command command = new DepositComand(AccountServiceImp.getInstance(), accnr, Double.parseDouble(JTextField_Deposit.getText()));
		CommandManager manager = CommandManager.getInstance();
		manager.setCommand(command);
		try {
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		dispose();
	}

}