package main.java.bank.domain;


import framework.visitor.Compute;
import framework.visitor.Elements;
import main.java.cs525.mum.dto.AccountDTO;

/**
 * Created by yf_zh on 2017/08/09.
 */
public class SavingAccount extends AccountDTO implements Elements {
    public SavingAccount(AccountDTO dto) {
        super(dto);
    }
    public SavingAccount() {
    }

    @Override
    public void accept(Compute compute) {
        compute.visitSavingAccount(this);
    }
}
