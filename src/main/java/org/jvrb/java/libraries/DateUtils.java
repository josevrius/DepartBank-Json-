package org.jvrb.java.libraries;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private DateUtils() {
    }

    public static String getCurrentDate() {
        return DATE_FORMAT.format(new Date());
    }
}
