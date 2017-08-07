package bank.ui;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
    	try {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			BankMainWindow win = new BankMainWindow("Bank Application");
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
    }
}