package com.github.KishanSital.authenticator.utils;

public enum StringUtilsMyPackage {
    // enumeration constants are implicit public static final
    INVALID_CREDENTIALS_MESSAGE(Constants.INVALID_CREDENTIALS_MESSAGE_VALUE),
    PROVIDE_USERNAME_MESSAGE(Constants.PROVIDE_USERNAME_MESSAGE_VALUE),
    PROVIDE_PASSWORD_MESSAGE(Constants.PROVIDE_PASSWORD_MESSAGE_VALUE),
    LOGIN_SUCCESS_MESSAGE(Constants.LOGIN_SUCCESS_MESSAGE_VALUE),
    INVALID_NUMBER_MESSAGE(Constants.INVALID_NUMBER_MESSAGE_VALUE),
    LOGGED_OUT_MESSAGE(Constants.LOGGED_OUT_MESSAGE_VALUE),
    STARTING_MENU_OPTIONS_MESSAGE(Constants.STARTING_MENU_OPTIONS_MESSAGE_VALUE),
    OPERATION_SUCCESSFUL_MESSAGE(Constants.OPERATION_SUCCESSFUL_MESSAGE_VALUE),
    OPERATION_FAILED_MESSAGE(Constants.OPERATION_FAILED_MESSAGE_VALUE),
    WELCOME_MESSAGE(Constants.WELCOME_MESSAGE_VALUE),
    MAXIMUM_TRIED_AMOUNT_MESSAGE(Constants.MAXIMUM_TRIED_AMOUNT_MESSAGE_VALUE);

    private String stringValue;

    private StringUtilsMyPackage(String stringValue) {
        this.stringValue = stringValue;
    }

    public static void displayWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE.getStringValue());
    }


    public String getStringValue() {
        return stringValue;
    }


    private static class Constants {
        static String INVALID_CREDENTIALS_MESSAGE_VALUE = "Credentials were invalid, please try again\n";
        static String PROVIDE_USERNAME_MESSAGE_VALUE = "Please enter your Username: ";
        static String PROVIDE_PASSWORD_MESSAGE_VALUE = "Please enter your Password: ";
        static String LOGIN_SUCCESS_MESSAGE_VALUE = "Login was successful\n";
        static String INVALID_NUMBER_MESSAGE_VALUE = "Please type a valid number\n";
        static String LOGGED_OUT_MESSAGE_VALUE = "You've been logged out successfully\n";
        static String STARTING_MENU_OPTIONS_MESSAGE_VALUE = "Choice must be between 1 and ";
        static String OPERATION_SUCCESSFUL_MESSAGE_VALUE = "Operation was successful\n";
        static String OPERATION_FAILED_MESSAGE_VALUE = "Operation failed\n";
        static String WELCOME_MESSAGE_VALUE = "db   d8b   db d88888b db       .o88b.  .d88b.  .88b  d88. d88888b \n" +
                "88   I8I   88 88'     88      d8P  Y8 .8P  Y8. 88'YbdP`88 88'     \n" +
                "88   I8I   88 88ooooo 88      8P      88    88 88  88  88 88ooooo \n" +
                "Y8   I8I   88 88~~~~~ 88      8b      88    88 88  88  88 88~~~~~ \n" +
                "`8b d8'8b d8' 88.     88booo. Y8b  d8 `8b  d8' 88  88  88 88.     \n" +
                " `8b8' `8d8'  Y88888P Y88888P  `Y88P'  `Y88P'  YP  YP  YP Y88888P"; //https://onlineasciitools.com/convert-text-to-ascii-art
        static String MAXIMUM_TRIED_AMOUNT_MESSAGE_VALUE = "Maximum amount of permitted tries have been reached, please restart the application\n";
    }

}


