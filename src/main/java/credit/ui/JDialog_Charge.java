package main.java.credit.ui;

import main.java.cs525.mum.commands.Command;
import main.java.cs525.mum.commands.CommandManager;
import main.java.cs525.mum.commands.WithdrawComand;
import main.java.cs525.mum.ui.WithdrawDialog;
import main.java.cs525.mum.util.ValidatorUtil;
import main.java.credit.services.AccountServiceImp;

public class JDialog_Charge extends WithdrawDialog {

	public JDialog_Charge(String aaccnr, double currentBal) {
		super(aaccnr, currentBal);
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		if (!ValidatorUtil.isNumeric(JTextField_AMT.getText())) {
			isNewWithdraw = false;
			dispose();
			return;
		}
		double deposit = Double.parseDouble(JTextField_AMT.getText());
		Command command = new WithdrawComand(AccountServiceImp.getInstance(), accnr, deposit);
		CommandManager manager = CommandManager.getInstance();
		manager.setCommand(command);
		try {
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		dispose();
	}

	@Override
	public void setComponentNames() {
		setTitle("Charge");
	}
}