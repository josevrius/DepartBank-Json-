package org.jvrb.java.entities.bank;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jvrb.java.entities.account.Account;
import org.jvrb.java.exceptions.AccountException;
import org.jvrb.java.libraries.EnterUtils;
import org.jvrb.java.libraries.ListUtils;
import org.jvrb.java.messages.MSG_ES;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public final class Bank {

    private static List<Account> accountsList = new ArrayList<>();
    private static final File ACCOUNTS_FILE = new File("./src/main/resources/accounts.json");

    private Bank() {
    }

    public static void createAccount() {
        System.out.println(MSG_ES.CREATE_HEADER);

        String number = EnterUtils.inputText(MSG_ES.NUMBER);
        String holder = EnterUtils.inputText(MSG_ES.HOLDER);
        double balance = EnterUtils.inputAmount(MSG_ES.BALANCE);

        try {
            Account account = new Account(number, holder, balance);
            int position = ListUtils.searchAccount(number, accountsList);

            if (position < 0) {
                accountsList.add(account);
                account.addMovementToHistory(balance, "+ ");
                saveAccounts();
                System.out.println(MSG_ES.CREATE_SUCCESS);
            } else {
                System.out.println(MSG_ES.CREATE_ERROR);
            }
        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        EnterUtils.pauseApp();
        System.out.println();
    }

    public static void deleteAccount() {
        System.out.println(MSG_ES.DELETE_HEADER);
        String number = EnterUtils.inputText(MSG_ES.NUMBER);

        int position = ListUtils.searchAccount(number, accountsList);

        if (position >= 0) {
            accountsList.remove(position);
            saveAccounts();
            System.out.println(MSG_ES.DELETE_SUCCESS);
        } else {
            System.out.println(MSG_ES.DELETE_ERROR);
        }
        System.out.println();
        EnterUtils.pauseApp();
        System.out.println();
    }

    public static Account getAccount() {
        String number = EnterUtils.inputText(MSG_ES.NUMBER);

        int position = ListUtils.searchAccount(number, accountsList);
        Account account = null;

        if (position >= 0) {
            account = accountsList.get(position);
        } else {
            System.out.println(MSG_ES.ACCOUNT_ERROR);
            System.out.println();
            EnterUtils.pauseApp();
            System.out.println();
        }
        return account;
    }

    public static void saveAccounts() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ACCOUNTS_FILE))) {
            bw.write(gson.toJson(accountsList));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadAccounts() {
        if (ACCOUNTS_FILE.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
                accountsList = new Gson().fromJson(br, new TypeToken<List<Account>>() {
                }.getType());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
