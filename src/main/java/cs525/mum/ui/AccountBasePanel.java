package main.java.cs525.mum.ui;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

@SuppressWarnings("serial")
public abstract class AccountBasePanel extends JDialog {
	
	public abstract void setButtonNames();
	public abstract void displayAccountList();
	public abstract void JButtonExit_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonAddAcc_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonDeposit_actionPerformed(MenuEvent e);
	public abstract void JButtonWithdraw_actionPerformed(MenuEvent e);
	public abstract void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonReport_actionPerformed(MenuEvent e);
	private JMenuBar menubar;
	private JMenu menu1, menu2, menu3;
	
	protected javax.swing.JButton JButton_AddAcc = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Report = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	
	boolean isAddNewAccount;
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Object rowdata[];
	void init() {
		menubar = new JMenuBar();
		// menu columns
		menu3 = new JMenu("Deposit");
		menu3.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				JButtonDeposit_actionPerformed(e);
			}

			@Override
			public void menuDeselected(MenuEvent e) {

			}

			@Override
			public void menuCanceled(MenuEvent e) {

			}
		});
		menu2 = new JMenu("Withdraw");
		menu2.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				JButtonWithdraw_actionPerformed(e);
			}

			@Override
			public void menuDeselected(MenuEvent e) {

			}

			@Override
			public void menuCanceled(MenuEvent e) {

			}
		});
		menu1 = new JMenu("Report"); // system management
		menu1.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				JButtonReport_actionPerformed(e);
			}

			@Override
			public void menuDeselected(MenuEvent e) {

			}

			@Override
			public void menuCanceled(MenuEvent e) {

			}
		});
		menubar.add(menu1); // Add menu into menubar
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar); // Add one menubar
	}
	public AccountBasePanel(String[]columns) {
		init();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setModal(true);
		this.setTitle("Account Information");
		this.setLayout(null);
		this.setSize(screenSize);

		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);

		for (String col:columns) {
			model.addColumn(col);
		}
		rowdata = new Object[columns.length];
		isAddNewAccount = false;

		this.add(JScrollPane1);
		JScrollPane1.setSize(screenSize);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(5, 5, 1150, 300);

		JTable1.setRowHeight(50);
		JScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


		displayAccountList();
		setButtonNames();
	}
}
