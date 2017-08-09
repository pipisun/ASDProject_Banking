package main.java.bank.services;

import framework.visitor.Compute;
import main.java.bank.domain.CheckingAccount;
import main.java.bank.domain.SavingAccount;

/**
 * Created by yf_zh on 2017/08/09.
 */
public class ComputeAnnualFee implements Compute<CheckingAccount, SavingAccount> {



    @Override
    public void visitSavingAccount(CheckingAccount checkingAccount) {
            checkingAccount.setInterest(0.9);
    }

    @Override
    public void visitCheckAccount(SavingAccount savingAccount) {
            savingAccount.setInterest(0.87);
    }
}
