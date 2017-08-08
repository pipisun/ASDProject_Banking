package main.java.cs525.mum.ui;

import main.java.cs525.mum.dto.PartyDTO;
import javax.swing.*;

public abstract class CustomerDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PartyDTO pojoP;
	protected String custType;
	protected boolean isAddNew = false;

	protected JLabel JLabel1 = new JLabel();
	protected JLabel JLabel2 = new JLabel();
	protected JLabel JLabel3 = new JLabel();
	protected JLabel JLabel4 = new JLabel();
	protected JLabel JLabel5 = new JLabel();
	protected JLabel JLabel6 = new JLabel();
	protected JLabel JLabel7 = new JLabel();
	protected JTextField JTextField_NAME = new JTextField();
	protected JTextField JTextField_CT = new JTextField();
	protected JTextField JTextField_ST = new JTextField();
	protected JTextField JTextField_STR = new JTextField();
	protected JTextField JTextField_ZIP = new JTextField();
	protected JTextField JTextField_EM = new JTextField();
	protected JButton JButton_OK = new JButton();
	protected JButton JButton_Cancel = new JButton();
	protected JTextField JTextField_NoOfEmp;
	protected JTextField JTextField_BD;
	
	public CustomerDialog(String custType) {
		this.custType = custType;
		if (this.custType.equalsIgnoreCase("P"))
			setTitle("Add Individual Customer");
		else
			setTitle("Add Corporate Customer");

		setModal(true);
		getContentPane().setLayout(null);
		setSize(270, 250);
		setVisible(false);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(55, 15, 60, 24);
		JLabel2.setText("Address");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(55, 39, 60, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(55, 63, 60, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(55, 87, 60, 24);
		JLabel5.setText("ZIP Code");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(55, 111, 60, 24);
		JLabel6.setText("Email");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(55, 135, 60, 24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(130, 21, 100, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(130, 45, 180, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(130, 69, 90, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(130, 93, 90, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(130, 117, 90, 20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(130, 141, 120, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(54, 216, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(168, 216, 100, 24);

		if ("P".equalsIgnoreCase(custType)) {
			JLabel7.setText("DOB");
			getContentPane().add(JLabel7);
			JLabel7.setForeground(java.awt.Color.black);
			JLabel7.setBounds(55, 159, 250, 24);
			
			JTextField_BD = new javax.swing.JTextField();
			getContentPane().add(JTextField_BD);
			JTextField_BD.setBounds(130, 165, 90, 20);
		} else {
			JLabel7.setText("Employees");
			getContentPane().add(JLabel7);
			JLabel7.setForeground(java.awt.Color.black);
			JLabel7.setBounds(55, 159, 350, 24);

			JTextField_NoOfEmp = new javax.swing.JTextField();
			getContentPane().add(JTextField_NoOfEmp);
			JTextField_NoOfEmp.setBounds(130, 165, 90, 20);
		}

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
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

	public abstract void JButtonOK_actionPerformed(java.awt.event.ActionEvent event);

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

	public PartyDTO getPojoParty() {
		return pojoP;
	}

	public boolean isAddNew() {
		return isAddNew;
	}
}