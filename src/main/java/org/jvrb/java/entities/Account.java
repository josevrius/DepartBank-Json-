package org.jvrb.java.entities;

import org.jvrb.java.exceptions.AccountException;
import org.jvrb.java.interfaces.IOperations;
import org.jvrb.java.libraries.CurrencyUtils;
import org.jvrb.java.libraries.DateUtils;
import org.jvrb.java.libraries.EnterUtils;
import org.jvrb.java.messages.MSG_ES;

import java.util.ArrayList;
import java.util.List;

public final class Account implements IOperations {

    private final String number;
    private String holder;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public Account(String number) throws AccountException {
        if (validateNumber(number)) {
            this.number = number;
        } else {
            throw new AccountException(MSG_ES.NUMBER_ERROR);
        }
    }

    public Account(String number, String holder, double balance) throws AccountException {
        if (validateNumber(number)) {
            this.number = number;
        } else {
            throw new AccountException(MSG_ES.NUMBER_ERROR);
        }
        if (validateHolder(holder)) {
            this.holder = holder;
        } else {
            throw new AccountException(MSG_ES.HOLDER_ERROR);
        }
        if (validateBalance(balance)) {
            this.balance = balance;
        } else {
            throw new AccountException(MSG_ES.BALANCE_ERROR);
        }
    }

    public String getNumber() {
        return number;
    }

    @Override
    public void deposit() {
        System.out.printf(MSG_ES.DEPOSIT_HEADER, number);
        double amount = EnterUtils.inputAmount(MSG_ES.AMOUNT);

        if (amount > 0) {
            balance += amount;
            limitHistory();
            addMovementToHistory(amount, "+ ");
            Bank.saveAccounts();
            System.out.println(MSG_ES.DEPOSIT_SUCCESS);
            warnAuthority(amount);
        } else {
            System.out.println(MSG_ES.AMOUNT_ERROR);
        }
        System.out.println();
        EnterUtils.pauseApp();
        System.out.println();
    }

    @Override
    public void withdraw() {
        System.out.printf(MSG_ES.WITHDRAW_HEADER, number);
        double amount = EnterUtils.inputAmount(MSG_ES.AMOUNT);

        if (amount > 0) {
            if ((balance - amount) >= -50) {
                balance -= amount;
                limitHistory();
                addMovementToHistory(amount, "- ");
                Bank.saveAccounts();
                System.out.println(MSG_ES.WITHDRAW_SUCCESS);
                warnAuthority(amount);
                warnNegative();
            } else {
                System.out.println(MSG_ES.OVERDRAWN_ERROR);
            }
        } else {
            System.out.println(MSG_ES.AMOUNT_ERROR);
        }
        System.out.println();
        EnterUtils.pauseApp();
        System.out.println();
    }

    @Override
    public void checkBalance() {
        System.out.printf(MSG_ES.BALANCE_HEADER, number);
        System.out.println(MSG_ES.BALANCE + CurrencyUtils.getCurrency(balance));

        System.out.println();
        EnterUtils.pauseApp();
        System.out.println();
    }

    @Override
    public void showHolder() {
        System.out.printf(MSG_ES.HOLDER_HEADER, number);
        System.out.println(MSG_ES.HOLDER + holder);

        System.out.println();
        EnterUtils.pauseApp();
        System.out.println();
    }

    @Override
    public void showHistory() {
        System.out.printf(MSG_ES.HISTORY_HEADER, number);
        for (String movement : history) {
            System.out.println(movement);
        }
        System.out.println();
        EnterUtils.pauseApp();
        System.out.println();
    }

    private boolean validateNumber(String number) {
        return number.matches("[A-Z]{2}\\d{22}");
    }

    private boolean validateHolder(String holder) {
        return holder.matches("[A-Za-zÁÉÍÓÚÜÑáéíóúüñ ]{1,30}");
    }

    private boolean validateBalance(double balance) {
        return balance >= 0;
    }

    private void limitHistory() {
        if (history.size() == 100) {
            history.removeFirst();
        }
    }

    void addMovementToHistory(double amount, String operation) {
        String formattedDate = DateUtils.getCurrentDate();
        String formattedAmount = CurrencyUtils.getCurrency(amount);
        String formattedBalance = CurrencyUtils.getCurrency(balance);

        history.add(String.format("%s %15s %15s", formattedDate, operation + formattedAmount, formattedBalance));
    }

    private void warnAuthority(double amount) {
        if (amount > 3000) {
            System.out.println(MSG_ES.AMOUNT_WARN);
        }
    }

    private void warnNegative() {
        if (balance < 0) {
            System.out.println(MSG_ES.NEGATIVE_WARN);
        }
    }
}
