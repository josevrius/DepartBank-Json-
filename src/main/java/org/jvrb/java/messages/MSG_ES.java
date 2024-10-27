package org.jvrb.java.messages;

public final class MSG_ES {

    public static final String APP_PAUSE = "Pulse ENTER para continuar ...: ";
    public static final String APP_EXIT = "Saliendo de la aplicación ...";

    public static final String NUMBER = "IBAN ......: ";
    public static final String HOLDER = "Titular ...: ";
    public static final String BALANCE = "Saldo .....: ";
    public static final String AMOUNT = "Importe ...: ";

    public static final String NUMBER_ERROR = "INFO ......: La cuenta no es válida";
    public static final String HOLDER_ERROR = "INFO ......: El titular no es válido";
    public static final String BALANCE_ERROR = "INFO ......: El saldo no es válido";
    public static final String AMOUNT_ERROR = "INFO ......: El importe no es válido";

    public static final String DEPOSIT_SUCCESS = "INFO ......: El importe se ha ingresado";
    public static final String WITHDRAW_SUCCESS = "INFO ......: El importe se ha retirado";

    public static final String CREATE_SUCCESS = "INFO ......: La cuenta ha sido creada";
    public static final String DELETE_SUCCESS = "INFO ......: La cuenta ha sido eliminada";
    public static final String CREATE_ERROR = "INFO ......: La cuenta ya existe en el sistema";
    public static final String DELETE_ERROR = "INFO ......: La cuenta no existe en el sistema";

    public static final String AMOUNT_WARN = "AVISO .....: Notificación a hacienda";
    public static final String NEGATIVE_WARN = "AVISO .....: Saldo negativo";
    public static final String ACCOUNT_ERROR = "INFO ......: La cuenta no existe en el sistema";
    public static final String OVERDRAWN_ERROR = "INFO ......: El importe supera el máximo permitido";
    public static final String OPTION_ERROR = """
            
            ERROR: Opción incorrecta
            """;

    public static final String DEPOSIT_HEADER = """
            INGRESAR IMPORTE [ %s ]
            =============================================
            """;

    public static final String WITHDRAW_HEADER = """
            RETIRAR IMPORTE [ %s ]
            ============================================
            """;

    public static final String BALANCE_HEADER = """
            CONSULTAR SALDO [ %s ]
            ============================================
            """;

    public static final String HOLDER_HEADER = """
            MOSTRAR TITULAR [ %s ]
            ============================================
            """;

    public static final String HISTORY_HEADER = """
            MOSTRAR HISTORIAL [ %s ]
            ===================================================
            Fecha      Hora             Importe           Saldo
            ---------------------------------------------------
            """;

    public static final String CREATE_HEADER = """
            CREAR CUENTA
            ============""";

    public static final String DELETE_HEADER = """
            ELIMINAR CUENTA
            ===============""";

    private MSG_ES() {
    }
}
