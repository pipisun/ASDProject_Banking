package main.java.bank.ui;

import com.sun.istack.internal.logging.Logger;
import main.java.com.cs.framework.controller.UserImp;
import main.java.com.cs.framework.model.concrete.Users;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.jvnet.substance.theme.SubstanceOliveTheme;
import org.jvnet.substance.watermark.SubstanceImageWatermark;
import util.framework.Adaptor;
import util.framework.Target;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.UIManager.*;

class Login extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		// ImageIcon image = new ImageIcon("d:\\bg.jpg");

		ImageIcon image = new ImageIcon(getClass().getResource("/main/java/images/loginBG.jpg"));
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
		setTitle("Login");
		// setLocationRelativeTo(null);

		// Toolkit toolkit = Toolkit.getDefaultToolkit();
		// int x = (int)(toolkit.getScreenSize().getWidth()- getWidth())/2;
		// int y = (int)(toolkit.getScreenSize().getHeight()- getHeight())/2;
		// setLocation(x, y);

	}

	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent ae) {
		String value1 = text1.getText();
		String value2 = text2.getText();

		UserImp userImp = new UserImp();
		Users user = (Users) userImp.login(value1, value2);
		System.out.println(user.getFullname());
		// use logging framework to record the login users.
		Target adaptor = new Adaptor();
		adaptor.configLog(1, 1);
		adaptor.setLog("User:  " + user.getFullname() + "   Login.");

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
			try {

				UIManager.setLookAndFeel(new SubstanceLookAndFeel());

				JFrame.setDefaultLookAndFeelDecorated(true);

				JDialog.setDefaultLookAndFeelDecorated(true);

				SubstanceLookAndFeel.setCurrentTheme(new SubstanceOliveTheme());

			} catch (Exception e) {

				System.err.println("Something went wrong!");
			}
			
			Login frame = new Login();
			frame.setSize(800, 650);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
