package bank.ui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.cs.framework.controller.UserManagmentImp;
import com.cs.framework.model.abstraction.AbstractPermission;
import com.cs.framework.model.abstraction.AbstractUser;
import com.cs.framework.model.concrete.Constant;
import com.cs.framework.model.concrete.Permission;
import com.cs.framework.model.concrete.Users;


public class PermissionPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private final static String[] columns = new String[] { "User Id", "Name" };
	private List<Permission> allPermissionList = new <Permission>ArrayList();
	private Map<String, Integer> userPermissionMap = new <String, Integer>HashMap();
	private JCheckBox cbPermissionList[] = null;

	JButton btSave = new JButton("Save");
	JButton btUndo = new JButton("Undo");

	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrPanUserList;
	private JPanel jPanelPermissionList;
	private Object rowdata[];


	public PermissionPanel() {		
		ini_compoments();	//ini the user table
		displayUserList();
		setAllPermissionList();
		setUserPermissionList();
		displayPermissionList();
	}
	
	
	private void setAllPermissionList() {

		allPermissionList = Constant.getStaticSystemPermissions(); //get from db

		
		if (allPermissionList.size() > 0) {
			cbPermissionList = new JCheckBox[allPermissionList.size()];

			for (int i = 0; i < allPermissionList.size(); i++) {
				cbPermissionList[i] = new JCheckBox();
				cbPermissionList[i].setBounds(10, 25 * i, 250, 24);

				Permission p = allPermissionList.get(i);
				cbPermissionList[i].setName(p.getPermissioncode());
				cbPermissionList[i].setText(p.getPermissionname());

				// redrawUI(cbPermissionList[i]);
				jPanelPermissionList.add(cbPermissionList[i]);
			}

			btSave.setBounds(100, 400, 80, 25);
			btSave.addActionListener(new ButtonAction());
			btUndo.setBounds(250, 400, 80, 25);
			btUndo.addActionListener(new ButtonAction());
			
			jPanelPermissionList.add(btSave);
			jPanelPermissionList.add(btUndo);
			
			jPanelPermissionList.revalidate();
			jPanelPermissionList.invalidate();
			jPanelPermissionList.repaint();

		}
	}

	private void setUserPermissionList() {
		Permission p1 = new Permission(1, "mItem01", "display user", "description");
		Permission p3 = new Permission(1, "mItem03", "display 003", "description");
		Permission p5 = new Permission(1, "mItem05", "display 005", "description");
		Permission p7 = new Permission(1, "mItem07", "display 007", "description");

		userPermissionMap.put(p1.getPermissioncode(), 0);
		userPermissionMap.put(p3.getPermissioncode(), 0);
		userPermissionMap.put(p5.getPermissioncode(), 0);
		userPermissionMap.put(p7.getPermissioncode(), 0);
	}

	private void displayPermissionList() {
		for (int i = 0; i < allPermissionList.size(); i++) {
			boolean b = userPermissionMap.containsKey(allPermissionList.get(i).getPermissioncode());
			cbPermissionList[i].setSelected(b);
			cbPermissionList[i].revalidate();
		}
	}

	private void updateUserPermissionList(int userId) {
		System.out.print("update permission for userid =" + userId);
		Permission p8 = new Permission(1, "mItem06", "display 006", "description");
		userPermissionMap.put(p8.getPermissioncode(), 0);

		displayPermissionList();
		this.revalidate();
		this.repaint();
	}

	public void displayUserList() {
		List<AbstractUser> userList = UserManagmentImp.getInstance().searchUser(new HashMap());
		if (userList != null) {
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (int i = 0; i < userList.size(); i++) {
				Users user = (Users) userList.get(i);
				if (user != null) {
					rowdata[0] = user.getUserid();
					rowdata[1] = user.getFullname();
					model.addRow(rowdata);
				}
			}
		}
	}

	private void ini_compoments(){
		setLayout(null);
		this.setBounds(0, 25, 1000, 800);
		JScrPanUserList = new JScrollPane();

		jPanelPermissionList = new JPanel();
		model = new DefaultTableModel();
		for (String col : columns) {
			model.addColumn(col);
		}
		rowdata = new Object[columns.length];

		JTable1 = new JTable(model);
		ListSelectionModel selectionModel = JTable1.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		selectionModel.addListSelectionListener(new MySelectionListener());

		this.add(JScrPanUserList);
		JScrPanUserList.setBounds(5, 10, 200, 450);
		JScrPanUserList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrPanUserList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JScrPanUserList.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 580, 500);

		jPanelPermissionList.setBounds(205, 10, 500, 450);
		jPanelPermissionList.setLayout(null);
		this.add(jPanelPermissionList);
		
		this.revalidate();
	}
	
	private void redrawUI(Component com) {
		Component parent = com.getParent();
		System.out.println("com.name = " + com.getName());
		while (parent != null) {
			System.out.println("parentName = " + parent.getName());
			parent.revalidate();
			parent.repaint();
			parent = this.getParent();
		}
	}

	protected javax.swing.JButton JButton_PersonCustomer = new javax.swing.JButton();
	protected javax.swing.JButton JButton_CompanyCustomer = new javax.swing.JButton();

	public void JButtonPerCust_actionPerformed(java.awt.event.ActionEvent event) {
		// JDialog_AddCutomer pac = new JDialog_AddCutomer("P");
		// pac.setBounds(350, 20, 500, 600);
		// pac.show();
		//
		// if (pac.isAddNew()) {
		// displayCustomerList();
		// JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		// }
	}

	public void JButtonCompCust_actionPerformed(java.awt.event.ActionEvent event) {

		// JDialog_AddCutomer pac = new JDialog_AddCutomer("C");
		// pac.setBounds(350, 20, 300, 300);
		// pac.show();
		//
		// if (pac.isAddNew()) {
		// displayCustomerList();
		// JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		// }
	}

	public void setButtonNames() {
		// JButton_CompanyCustomer.setText("Add Company Customer");
		// JButton_PersonCustomer.setText("Add Person Customer");
	}

	
	
	//class for table row selection event
	class MySelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {

			System.out.println("isAdjusting = " + e.getValueIsAdjusting());
			if (e.getValueIsAdjusting()) { // we only concernt the change for
											// the first column
				int selectionIndex = JTable1.getSelectionModel().getMinSelectionIndex();
				if (selectionIndex >= 0) {
					int userId = (int) model.getValueAt(selectionIndex, 0);
					System.out.println("selected user id = " + userId);
					updateUserPermissionList(userId);
				}
			}
		}
	}

	//class for button action event
	class ButtonAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == btSave)
				//JButtonPerCust_actionPerformed(event);
				System.out.println("trigger btSave");
			else if (object == btUndo)
				//JButtonCompCust_actionPerformed(event);
				System.out.println("trigger btUndo");
		}
	}
}