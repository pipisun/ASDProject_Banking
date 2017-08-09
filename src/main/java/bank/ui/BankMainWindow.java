package main.java.bank.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import com.mysql.jdbc.Util;
import util.framework.Adaptor;
import util.framework.Target;

public class BankMainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenuBar menubar;
	private JMenu menu1, menu2, menu3, menu4;
	private JMenuItem item11, item12, item13, item21, item22, item23, item31, item32, item33, item41, item42, item43;

	private Container contentPane;
	private static JPanel panelmain = new JPanel();

	private static JLabel lblBackgroundImage;
	static URL imgURL = Util.class.getClassLoader().getResource("main/java/images/IMG_430122.jpg");

	// set location x,y
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	private int screenWidth = screenSize.width / 4;
	private int screenHeight = screenSize.height / 4;
	private int height = this.getHeight();
	private int width = this.getWidth();

	private int wx = screenWidth - width;
	private int wy = screenHeight - height;

	public BankMainWindow() {
	}

	public BankMainWindow(String s) {
		init(s);
		// setBackGround();
		// add(lblBackgroundImage,BorderLayout.WEST);
		// setContentPane(panelmain);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		theHandler handler = new theHandler();
		item11.addActionListener(handler);
		item12.addActionListener(handler);
		item13.addActionListener(handler);
		item11.setName("BankMainWindow.Menu1.Item11");
		item12.setName("BankMainWindow.Menu1.Item12");
		item13.setName("BankMainWindow.Menu1.Item13");

		item21.addActionListener(handler);
		item22.addActionListener(handler);
		item23.addActionListener(handler);
		item21.setName("BankMainWindow.Menu2.Item21");
		item22.setName("BankMainWindow.Menu2.Item22");
		item23.setName("BankMainWindow.Menu2.Item23");

		item31.addActionListener(handler);
		item32.addActionListener(handler);
		item33.addActionListener(handler);
		item31.setName("BankMainWindow.Menu3.Item31");
		item32.setName("BankMainWindow.Menu3.Item32");
		item33.setName("BankMainWindow.Menu3.Item33");

		item41.addActionListener(handler);
		item42.addActionListener(handler);
		item43.addActionListener(handler);
		item41.setName("BankMainWindow.Menu4.Item41");
		item42.setName("BankMainWindow.Menu4.Item42");
		item43.setName("BankMainWindow.Menu4.Item43");

	}

	static void setBackGround() {
		lblBackgroundImage = new JLabel();
		lblBackgroundImage.setLayout(new FlowLayout());

		ImageIcon image = new ImageIcon(imgURL);
		lblBackgroundImage.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		if (image != null) {
			lblBackgroundImage.setIcon(image);
			lblBackgroundImage.setText("");
		}
		lblBackgroundImage.setLayout(new BorderLayout());
		// panelmain.add(lblBackgroundImage, imgURL);
	}

	void init(String s) {
		setTitle(s);
		menubar = new JMenuBar();
		// menu columns
		menu3 = new JMenu("Customer");
		menu2 = new JMenu("Account");
		menu1 = new JMenu("System"); // system management
//		menu4 = new JMenu("Help");

		/**
		 * 1st menu
		 */
		item11 = new JMenuItem("Add Corporate Customer");
		item12 = new JMenuItem("Add Individual Customer");
		item13 = new JMenuItem("View Customers Info");

		item21 = new JMenuItem("Create Account");
		item22 = new JMenuItem("Adjust Interest");
		item23 = new JMenuItem("View Accounts Info");

		// system management menu items
		item31 = new JMenuItem("View User");
		item32 = new JMenuItem("Maintain User");
		item33 = new JMenuItem("Manage Privilege");
		item11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));

//		item41 = new JMenuItem("Contents");
//		item42 = new JMenuItem("About...");
		item43 = new JMenuItem("Exit");

		item11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		item13.setAccelerator(KeyStroke.getKeyStroke("S"));
		menu3.add(item11);
		menu3.add(item12);
		menu3.addSeparator();
		menu3.add(item13);

		item21.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		item22.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		item23.setAccelerator(KeyStroke.getKeyStroke("D"));
		menu2.add(item21);
		menu2.add(item22);
		menu2.addSeparator();
		menu2.add(item23);

		menu1.add(item31);
		menu1.add(item32);
		menu1.add(item33);
		menu1.addSeparator();
		menu1.add(item43);
		
//		item41.setAccelerator(KeyStroke.getKeyStroke("C"));
//		item43.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
//		item41.setEnabled(false);
//		item42.setEnabled(false);
//		menu4.add(item41);
//		menu4.add(item42);
//		menu4.addSeparator();
//		menu4.add(item43);

		menubar.add(menu1); // Add menu into menubar
		menubar.add(menu2);
		menubar.add(menu3);
//		menubar.add(menu4);
		setJMenuBar(menubar); // Add one menubar
	}

	private class theHandler implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == item43) {
				exitApplication();
			} else if (event.getSource() == item11) {
				MaintainCustomers pac = new MaintainCustomers("C");
				pac.setBounds(wx, wy, 400, 300);
				pac.setVisible(true);
				pac.setResizable(false);
			} else if (event.getSource() == item12) {
				MaintainCustomers pac = new MaintainCustomers("P");
				pac.setBounds(wx, wy, 400, 300);
				pac.setVisible(true);
				pac.setResizable(false);
			} else if (event.getSource() == item21) {
				JDialog_AddAccount pac = new JDialog_AddAccount();
				pac.setBounds(wx, wy, 600, 400);
				pac.setVisible(true);
				pac.setResizable(false);
			} else if (event.getSource() == item22) {
				JDialog_AddInterest wd = new JDialog_AddInterest();
				wd.setBounds(wx, wy, 300, 160);
				wd.setVisible(true);
				wd.setResizable(false);
			} else if (event.getSource() == item13) {
				revalidate();
				CustomerPanel custPane = new CustomerPanel();
				custPane.setBounds(wx - 100, wy, 950, 360);
				custPane.setVisible(true);
				custPane.setResizable(false);
			} else if (event.getSource() == item23) {
				revalidate();
				AccountPanel accPane = new AccountPanel();
				accPane.setBounds(wx - 100, wy, 950, 400);
				accPane.setVisible(true);
				accPane.setResizable(false);

			} else if (event.getSource() == item31) {
				validate();
				contentPane = getContentPane();
				UserPanel userPane = new UserPanel();
				userPane.setBounds(wx, wy, 950, 360);
				userPane.setVisible(true);
				userPane.setResizable(false);
			} else if (event.getSource() == item33) {
				validate();
				contentPane = getContentPane();
				PermissionPanel permPanel = new PermissionPanel();
				permPanel.setBounds(wx, wy - 100, 600, 550);
				permPanel.setVisible(true);
				permPanel.setResizable(false);
				// contentPane.add(permPanel, BorderLayout.SOUTH);

			} else if (event.getSource() == item32) {
				JDialog_AddUser au = new JDialog_AddUser();
				au.setBounds(wx, wy, 300, 400);
				au.setVisible(true);
				au.setResizable(false);
			}
		}
	}

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == BankMainWindow.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}
}