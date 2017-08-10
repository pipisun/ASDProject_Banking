package main.java.bank.ui;

import main.java.cs525.mum.ui.AddUserDialog;

import main.java.com.cs.framework.controller.UserManagmentImp;
import main.java.com.cs.framework.model.concrete.Users;

public class JDialog_AddUser extends AddUserDialog {

	public JDialog_AddUser() {
		super();
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		try {
			isAddNew = true;
			user = new Users();
			user.setFullname(JTextField_NAME.getText());
			user.setCity(JTextField_CT.getText());
			user.setEmail(JTextField_EM.getText());
			user.setZipcode(Integer.parseInt(JTextField_ZIP.getText()));
			user.setStreet(JTextField_STR.getText());
			user.setState(JTextField_ST.getText());
			user.setPassword(JTextField_PW.getText());
			//user.setBirthyear(Integer.parseInt(JTextField_BD.getText()));
			
			UserManagmentImp.getInstance().addUser(user);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		dispose();
	}
}