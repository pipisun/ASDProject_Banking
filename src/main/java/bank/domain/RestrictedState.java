package main.java.bank.domain;

import framework.state.AccountState;
import main.java.cs525.mum.dto.AccountDTO;
import main.java.cs525.mum.entities.Account;

/**
 * Created by yf_zh on 2017/08/09.
 */
public class RestrictedState implements AccountState {

    Account dto;

    public RestrictedState(Account dto) {
        this.dto = dto;
    }

    @Override
    public void deposit(double v) {
        //dto.setBalance(dto.getBalance() + v);
        stateCheck(dto.getBalance() + v);
    }

    @Override
    public boolean withdraw(double v) {
        System.out.println("Account is restricted");
        stateCheck(dto.getBalance());
        return false;
    }

    @Override
    public void computeInterest() {
        System.out.println("calculate the Interest");
    }

    @Override
    public void stateCheck(double amount) {
        if(amount > 0) {
            dto.setState(new NormalState(dto));
        }
        else if(amount > -2000) {
            dto.setState(new OverdraftState(dto));
        }

    }
}
