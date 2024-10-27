package org.jvrb.java.libraries;

import org.jvrb.java.messages.MSG_ES;

import java.util.Scanner;

public final class EnterUtils {

    private static final Scanner scanner = new Scanner(System.in);

    private EnterUtils() {
    }

    public static void pauseApp() {
        System.out.print(MSG_ES.APP_PAUSE);
        scanner.nextLine();
    }

    public static String inputOption(String menu, String regex, String errorMessage) {
        String input;
        boolean inputOK = false;

        do {
            System.out.print(menu);
            input = scanner.nextLine();

            if (input.matches(regex)) {
                inputOK = true;
            } else {
                System.out.println(errorMessage);
            }
        } while (!inputOK);

        return input;
    }

    public static String inputText(String userMessage) {
        System.out.print(userMessage);
        return scanner.nextLine();
    }

    public static double inputAmount(String userMessage) {
        double input;

        try {
            System.out.print(userMessage);
            input = scanner.nextDouble();
        } catch (Exception e) {
            input = -1;
        } finally {
            scanner.nextLine();
        }
        return input;
    }
}
