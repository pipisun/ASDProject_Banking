package main.java.bank.domain;

import framework.state.AccountState;

import main.java.cs525.mum.entities.Account;

/**
 * Created by yf_zh on 2017/08/09.
 */
public class NormalState implements AccountState {
    Account dto;

    public NormalState(Account dto) {
        this.dto = dto;
    }

    @Override
    public void deposit(double v) {
        dto.setBalance(dto.getBalance() + v);
        stateCheck(v);
    }

    @Override
    public boolean withdraw(double v) {

        //dto.setBalance(dto.getBalance() - v);
        stateCheck(dto.getBalance() - v);
        return true;
    }

    @Override
    public void computeInterest() {

        System.out.println("calculate the Interest");
    }

    @Override
    public void stateCheck(double amount) {
        if (amount > -2000 && amount <= 0) {
            dto.setState(new OverdraftState(dto));
        }
        else if (amount == -2000) {
            dto.setState(new RestrictedState(dto));
        }
        else if (amount < -2000) {
            System.out.println("Operationg limited！");
        }
    }
}
