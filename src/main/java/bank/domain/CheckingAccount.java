package main.java.bank.domain;

import framework.visitor.Compute;
import framework.visitor.Elements;
import main.java.cs525.mum.dto.AccountDTO;

/**
 * Created by yf_zh on 2017/08/09.
 */
public class CheckingAccount extends AccountDTO {
    public CheckingAccount(AccountDTO dto) {
        super(dto);
    }
    public CheckingAccount() {

    }
    @Override
    public void accept(Compute compute) {
        compute.visitCheckAccount(this);
    }
}
