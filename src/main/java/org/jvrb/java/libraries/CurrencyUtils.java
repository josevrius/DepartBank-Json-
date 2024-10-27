package org.jvrb.java.libraries;

import java.text.NumberFormat;
import java.util.Locale;

public final class CurrencyUtils {

    public static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.of("ES", "es"));

    private CurrencyUtils() {
    }

    public static String getCurrency(double balance) {
        return CURRENCY_FORMAT.format(balance);
    }
}
