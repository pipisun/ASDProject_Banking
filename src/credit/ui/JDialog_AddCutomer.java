package credit.ui;

import cs525.mum.commands.Command;
import cs525.mum.commands.CommandManager;
import cs525.mum.commands.CreatePartyCommand;
import cs525.mum.dto.PartyDTO;
import cs525.mum.ui.AddCutomerDialog;
import cs525.mum.util.GeneratorUtil;
import cs525.mum.util.ValidatorUtil;
import credit.services.PartyServiceImp;

public class JDialog_AddCutomer extends AddCutomerDialog {

	public JDialog_AddCutomer(String custType) {
		super(custType);
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		try {
			isAddNew = true;
			pojoP = new PartyDTO();
			pojoP.setName(JTextField_NAME.getText());
			pojoP.setCity(JTextField_CT.getText());
			pojoP.setEmail(JTextField_EM.getText());
			pojoP.setZip(JTextField_ZIP.getText());
			pojoP.setStreet(JTextField_STR.getText());
			pojoP.setState(JTextField_ST.getText());
			if ("P".equalsIgnoreCase(custType)) {
				pojoP.setBirthDate(GeneratorUtil.getDateFromString(JTextField_BD.getText()));
				pojoP.setType("P");
			} else {
				if (ValidatorUtil.isNumeric(JTextField_NoOfEmp.getText())) {
					pojoP.setNumberOfEmployees(Integer.parseInt(JTextField_NoOfEmp.getText()));
				} else {
					pojoP.setNumberOfEmployees(0);
				}
				pojoP.setType("C");
			}
			Command command = new CreatePartyCommand(PartyServiceImp.getInstance(), pojoP);
			CommandManager manager = CommandManager.getInstance();
			manager.setCommand(command);
			manager.invokeCommand();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		dispose();
	}
}