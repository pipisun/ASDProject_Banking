package main.java.bank.domain;

import framework.command.Command;
import framework.command.CommandManager;
import framework.state.AccountState;
import main.java.bank.services.AccountServiceImp;
import main.java.cs525.mum.commands.DepositComand;
import main.java.cs525.mum.commands.WithdrawComand;
import main.java.cs525.mum.entities.Account;

/**
 * Created by yf_zh on 2017/08/09.
 */
public class OverdraftState implements AccountState {

    Account dto;

    public OverdraftState(Account dto) {
        this.dto = dto;
    }

    @Override
    public void deposit(double v, String accnr) {
        Command command = new DepositComand(AccountServiceImp.getInstance(), accnr, v);
        CommandManager manager = CommandManager.getInstance();
        manager.setCommand(command);
        try {
            manager.invokeCommand();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        stateCheck(dto.getBalance() + v);
    }

    @Override
    public boolean withdraw(double v,String accnr) {

        //dto.setBalance(dto.getBalance() - v);
        stateCheck(dto.getBalance() - v);
        Command command = new WithdrawComand(AccountServiceImp.getInstance(), accnr, v);
        CommandManager manager = CommandManager.getInstance();
        manager.setCommand(command);

        try {
            manager.invokeCommand();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void computeInterest() {

        System.out.println("calculate the Interest");
    }

    @Override
    public void stateCheck(double amount) {
        if (amount > 0) {
            dto.setState(new NormalState(dto));
        }
        else if (amount == -2000) {
            dto.setState(new RestrictedState(dto));
        }
        else if (amount < -2000) {
            System.out.println("Operation limited！");
        }
    }
}
