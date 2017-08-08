package main.java.bank.services;

import framework.iterator.AbstractIterator;

import java.util.List;

/**
 * Created by yf_zh on 2017/08/08.
 */
public class AccountIterator implements AbstractIterator {

    private List accounts;
    private int cursor1;
    private int cursor2;

    public static AccountIterator getInstance(AccountList list) {
        return new AccountIterator(list);
    }

    private AccountIterator(AccountList list) {

        this.accounts = list.getObjects();
        cursor1 = 0;
        cursor2 = accounts.size() -1;
    }
    @Override
    public void next() {
        if(cursor1 < accounts.size()) {
            cursor1++;
        }
    }

    @Override
    public boolean isLast() {
        return (cursor1 == accounts.size());
    }

    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2--;
        }
    }

    @Override
    public boolean isFirst() {
        return (cursor2 == -1);
    }

    @Override
    public Object getNextItem() {
        return accounts.get(cursor1);
    }

    @Override
    public Object getPreviousItem() {
        return accounts.get(cursor2);
    }
}
