package main.java.bank.ui;

import main.java.bank.dal.AccountDAOImp;
import main.java.bank.domain.NormalState;
import main.java.bank.domain.OverdraftState;
import main.java.bank.domain.RestrictedState;
import main.java.cs525.mum.entities.Account;
import main.java.cs525.mum.ui.WithdrawDialog;
import main.java.cs525.mum.util.ValidatorUtil;

public class JDialog_Withdraw extends WithdrawDialog {

	public JDialog_Withdraw(String aaccnr, double currentBal) {
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

		Account account = new AccountDAOImp().find(accnr);
		if (account.getBalance() > -2000 && account.getBalance() <= 0) {
			account.setState(new OverdraftState(account));
		}
		else if (account.getBalance() < -2000) {
			account.setState(new RestrictedState(account));
		}
		else {
			account.setState(new NormalState(account));
		}
		if (!account.withdraw(deposit, accnr)) {
			super.JLabelAlert.show();
			return;
		}

		dispose();
	}

	@Override
	public void setComponentNames() {
		setTitle("Withdraw");
	}
}