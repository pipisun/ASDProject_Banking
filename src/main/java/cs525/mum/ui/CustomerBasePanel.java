package main.java.cs525.mum.ui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public abstract class CustomerBasePanel extends JDialog {

	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Object rowdata[];

	public CustomerBasePanel(String[] columns) {
		setModal(true);
		getContentPane().setLayout(null);
		
		String strClassName = this.getClass().getSimpleName();
		if(strClassName.equals("CustomerPanel"))
			this.setTitle("View Customers");
		else
			this.setTitle("View Users");
		
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		for (String col:columns) {
			model.addColumn(col);
		}
		rowdata = new Object[columns.length];

		JTable1 = new JTable(model);
		this.add(JScrollPane1);
		JScrollPane1.setBounds(5, 10, 912, 200);
		JScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 580, 500);

	
		displayCustomerList();
	}
	
    protected javax.swing.JButton JButton_PersonCustomer = new javax.swing.JButton();
    protected javax.swing.JButton JButton_CompanyCustomer = new javax.swing.JButton();
	
    public abstract void setButtonNames();
	public abstract void displayCustomerList();
    public abstract void JButtonPerCust_actionPerformed(java.awt.event.ActionEvent event);
    public abstract void JButtonCompCust_actionPerformed(java.awt.event.ActionEvent event);
}
