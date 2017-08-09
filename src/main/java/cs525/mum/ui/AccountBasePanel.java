package main.java.cs525.mum.ui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

@SuppressWarnings("serial")
public abstract class AccountBasePanel extends JDialog {

	boolean isAddNewAccount;
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Object rowdata[];

	public AccountBasePanel(String[]columns) {
		this.setModal(true);
		this.setTitle("Manage Account");
		this.setLayout(null);
		this.setBounds(10, 50, 900, 600);

		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);

		for (String col:columns) {
			model.addColumn(col);
		}
		rowdata = new Object[columns.length];
		isAddNewAccount = false;

		this.add(JScrollPane1);
		JScrollPane1.setBounds(5, 100, 750, 300);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(5, 100, 750, 300);

		JTable1.setRowHeight(50);
		JScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.add(JButton_Deposit);
		JButton_Deposit.setText("Deposit");
		JButton_Deposit.setBounds(770, 50, 120, 33);
		
		this.add(JButton_Withdraw);
		JButton_Withdraw.setText("Withdraw");
		JButton_Withdraw.setBounds(770, 100, 120, 33);

		this.add(JButton_Report);
		JButton_Report.setText("Report");
		JButton_Report.setBounds(770, 150, 120, 33);


		SymAction lSymAction = new SymAction();
		JButton_AddAcc.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Report.addActionListener(lSymAction);
		JButton_Exit.addActionListener(lSymAction);
		
		displayAccountList();
		setButtonNames();
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Report)
				JButtonReport_actionPerformed(event);
		}
	}
	
	public abstract void setButtonNames();
	public abstract void displayAccountList();
	public abstract void JButtonExit_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonAddAcc_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event);
	public abstract void JButtonReport_actionPerformed(java.awt.event.ActionEvent event);
	
	protected javax.swing.JButton JButton_AddAcc = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Report = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Exit = new javax.swing.JButton();
}
