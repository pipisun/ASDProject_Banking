package bank.ui;

import javax.swing.*;

import com.cs.framework.controller.UserImp;
import com.cs.framework.model.concrete.Users;

import java.awt.*;
import java.awt.event.*;

class Login extends JFrame implements ActionListener {
	JButton SUBMIT;
	JPanel panel;
	JLabel label1, label2, lblBackgroundImage;

	final JTextField text1, text2;

	Login() {
		label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
		text2 = new JPasswordField(15);
		// this.setLayout(new BorderLayout());

		SUBMIT = new JButton("Login");

		// panel=new JPanel(new GridLayout(3,1));
		panel = new JPanel(new FlowLayout());

		lblBackgroundImage = new JLabel();
		lblBackgroundImage.setLayout(new FlowLayout());
		// sets background image of panel
		//ImageIcon image = new ImageIcon("d:\\bg.jpg");

		ImageIcon image = new ImageIcon(
		  getClass().getResource(
		  "/images/loginBG.jpg"));
		if (image != null) {
			lblBackgroundImage.setIcon(image);
			lblBackgroundImage.setText("");
		}
		// lblBackgroundImage.setIcon(new ImageIcon("..."));
		lblBackgroundImage.setLayout(new BorderLayout());

		panel.add(lblBackgroundImage);

		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(SUBMIT);

		add(panel, BorderLayout.CENTER);
		SUBMIT.addActionListener(this);
		setTitle("LOGIN FORM");
		// setLocationRelativeTo(null);

		// Toolkit toolkit = Toolkit.getDefaultToolkit();
		// int x = (int)(toolkit.getScreenSize().getWidth()- getWidth())/2;
		// int y = (int)(toolkit.getScreenSize().getHeight()- getHeight())/2;
		// setLocation(x, y);

	}

	public void actionPerformed(ActionEvent ae) {
		String value1 = text1.getText();
		String value2 = text2.getText();

		UserImp userImp = new UserImp();
		Users user = (Users) userImp.login(value1, value2);
		System.out.println(user.getFullname());

		if (user != null) {
			// if (value1.equals("test") && value2.equals("test")) {
			BankMainWindow page = new BankMainWindow("Bank Application");
			// page.setVisible(true);
			// JLabel label = new JLabel("Welcome:"+value1);
			// page.getContentPane().add(label);
			this.setVisible(false);
		} else {
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

class LoginFrame {
	public static void main(String arg[]) {
		try {
			Login frame = new Login();
			frame.setSize(800, 650);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
