package main.java.cs525.mum.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.java.cs525.mum.dto.AccountDTO;

public abstract class AddAccountDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JLabel JLabel1 = new JLabel();
	protected JLabel JLabel2 = new JLabel();
	protected JTextField JTextField_BALANCE = new JTextField();
	protected JButton JButton_OK = new JButton();
	protected JButton JButton_Cancel = new JButton();
	protected JRadioButton JRadioButton_First = new JRadioButton();
	protected JRadioButton JRadioButton_Second = new JRadioButton();
	protected ButtonGroup JRadioButton_Group = new ButtonGroup();

	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Object rowdata[];
	protected String accType;

	protected AccountDTO pojoA;
	protected boolean isAddNew = false;

	public AddAccountDialog() {

		JRadioButton_Group.add(JRadioButton_First);
		JRadioButton_Group.add(JRadioButton_Second);
		JRadioButton_First.setSelected(true);
		JRadioButton_Second.setSelected(false);
		// JRadioButton_Third.setSelected(false);
		accType = "G";
		setTitle("Add Account");
		setModal(true);
		this.setLayout(null);
		setSize(400, 300);
		setVisible(false);

		JRadioButton_First.setText("Gold");
		JRadioButton_First.setActionCommand("Gold");
		this.add(JRadioButton_First);
		JRadioButton_First.setBounds(40, 0, 120, 24);

		JRadioButton_Second.setText("Silver");
		JRadioButton_Second.setActionCommand("Silver");
		this.add(JRadioButton_Second);
		JRadioButton_Second.setBounds(180, 0, 120, 24);

		// JRadioButton_Third.setText("Bronze");
		// JRadioButton_Third.setActionCommand("Bronze");
		// this.add(JRadioButton_Third);
		// JRadioButton_Third.setBounds(240, 0, 120, 24);

		JLabel1.setText("Balance");
		this.add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 30, 80, 24);
		this.add(JTextField_BALANCE);
		JTextField_BALANCE.setBounds(80, 30, 156, 20);

		JLabel2.setText("Please select a customer from table:");
		this.add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 60, 350, 24);

		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		model.addColumn("Customer No");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("Account Type");
		model.addColumn("Email");
		model.addColumn("DOB");
		model.addColumn("Employee No");
		rowdata = new Object[7];

		displayCustomerList();

		JTable1 = new JTable(model);
		this.add(JScrollPane1);
		JScrollPane1.setBounds(12, 85, 544, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("Create");
		this.add(JButton_OK);
		JButton_OK.setBounds(30, 280, 80, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		this.add(JButton_Cancel);
		JButton_Cancel.setBounds(130, 280, 100, 24);

		SymMouse aSymMouse = new SymMouse();
		JRadioButton_First.addMouseListener(aSymMouse);
		JRadioButton_Second.addMouseListener(aSymMouse);
		// JRadioButton_Third.addMouseListener(aSymMouse);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);

		initial();
	}

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_First)
				JRadioButtonFirst_mouseClicked(event);
			else if (object == JRadioButton_Second)
				JRadioButtonSecond_mouseClicked(event);
			// else if (object == JRadioButton_Third)
			// JRadioButtonThird_mouseClicked(event);
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK) {
				JButtonOK_actionPerformed(event);
				isAddNew = true;
			} else if (object == JButton_Cancel) {
				JButtonCalcel_actionPerformed(event);
				isAddNew = false;
			}
		}
	}

	public abstract void initial();

	public abstract void displayCustomerList();

	public abstract void JButtonOK_actionPerformed(java.awt.event.ActionEvent event);

	public abstract void JRadioButtonFirst_mouseClicked(java.awt.event.MouseEvent event);

	public abstract void JRadioButtonSecond_mouseClicked(java.awt.event.MouseEvent event);

	public abstract void JRadioButtonThird_mouseClicked(java.awt.event.MouseEvent event);

	final void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

	public AccountDTO getPojoAccount() {
		return pojoA;
	}

	public boolean isAddNew() {
		return isAddNew;
	}
}
