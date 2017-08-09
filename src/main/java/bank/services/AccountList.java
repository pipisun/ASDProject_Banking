package main.java.bank.services;

import framework.iterator.AbstractIterator;
import framework.iterator.AbstractObjectList;
import main.java.bank.services.AccountIterator;

import java.util.List;

/**
 * Created by yf_zh on 2017/08/08.
 */
public class AccountList extends AbstractObjectList {
    public AccountList(List accounts) {
        super(accounts);
    }

    @Override
    public AbstractIterator createIterator() {

        return AccountIterator.getInstance(this);
    }

}


