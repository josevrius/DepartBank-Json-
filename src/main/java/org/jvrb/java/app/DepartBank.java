package org.jvrb.java.app;

import org.jvrb.java.entities.bank.Bank;

public final class DepartBank {

    public void launchApp() {
        System.out.println();
        Bank.loadAccounts();
        DepartBankCore.launchMenu();
    }
}