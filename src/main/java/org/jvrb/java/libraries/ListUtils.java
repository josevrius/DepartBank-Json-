package org.jvrb.java.libraries;

import org.jvrb.java.entities.Account;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ListUtils {

    private static final Comparator<Account> ASCENDING_ORDER = (a, b) -> a.getNumber().compareTo(b.getNumber());

    private ListUtils() {
    }

    public static int searchAccount(String number, List<Account> listAccounts) {
        int position;

        try {
            listAccounts.sort(ASCENDING_ORDER);
            position = Collections.binarySearch(listAccounts, new Account(number), ASCENDING_ORDER);
        } catch (Exception e) {
            position = -1;
        }
        return position;
    }
}
