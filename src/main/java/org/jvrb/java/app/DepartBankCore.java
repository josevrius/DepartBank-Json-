package org.jvrb.java.app;

import org.jvrb.java.entities.account.Account;
import org.jvrb.java.entities.bank.Bank;
import org.jvrb.java.libraries.EnterUtils;
import org.jvrb.java.messages.MSG_ES;

public final class DepartBankCore {

    private static final String OPTIONS_0 = "[0-3]";
    private static final String MENU_0 = """
            MENU DEPARTBANK
            ===============
            [1] Crear Cuenta
            [2] Eliminar Cuenta
            [3] Gestion Cuenta
            
            [0] Salir
            
            Opción ....:\s""";

    private static final String OPTIONS_3 = "[0-5]";
    private static final String MENU_3 = """
            MENU GESTIÓN CUENTA [ %s ]
            ================================================
            [1] Ingresar importe
            [2] Retirar importe
            [3] Consultar saldo
            [4] Mostrar titular
            [5] Mostrar historial
            
            [0] Menú anterior
            
            Opción ....:\s""";

    private DepartBankCore() {
    }

    static void launchMenu() {
        String option;
        boolean exit = false;

        do {
            option = EnterUtils.inputOption(MENU_0, OPTIONS_0, MSG_ES.OPTION_ERROR);
            switch (option) {
                case "1":
                    System.out.println();
                    Bank.createAccount();
                    break;
                case "2":
                    System.out.println();
                    Bank.deleteAccount();
                    break;
                case "3":
                    launchMenu3();
                    break;
                default:
                    exit = true;
                    System.out.println();
                    System.out.println(MSG_ES.APP_EXIT);
            }
        } while (!exit);
    }

    static void launchMenu3() {
        Account account = Bank.getAccount();

        if (account != null) {
            String option;
            boolean exit = false;

            do {
                option = EnterUtils.inputOption(String.format(MENU_3, account.getNumber()), OPTIONS_3, MSG_ES.OPTION_ERROR);
                switch (option) {
                    case "1":
                        System.out.println();
                        account.deposit();
                        break;
                    case "2":
                        System.out.println();
                        account.withdraw();
                        break;
                    case "3":
                        System.out.println();
                        account.checkBalance();
                        break;
                    case "4":
                        System.out.println();
                        account.showHolder();
                        break;
                    case "5":
                        System.out.println();
                        account.showHistory();
                        break;
                    default:
                        exit = true;
                        System.out.println();
                }
            } while (!exit);
        }
    }
}
