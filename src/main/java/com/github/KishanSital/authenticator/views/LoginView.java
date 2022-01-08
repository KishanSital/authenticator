package com.github.KishanSital.authenticator.views;

import com.github.KishanSital.authenticator.serviceImpl.TriesValidationServiceImpl;
import com.github.KishanSital.authenticator.services.LoginService;
import com.github.KishanSital.authenticator.services.PrintMessageService;
import com.github.KishanSital.authenticator.utils.IntUtilsMyPackage;
import com.github.KishanSital.authenticator.utils.StringUtilsMyPackage;
import com.github.KishanSital.authenticator.exceptions.LoginException;

import java.util.Scanner;

public final class LoginView {
    public PrintMessageService println = System.out::println;
    private LoginService loginService;
    private Scanner scanner;
    private String[] args;


    public LoginView(LoginService loginService) {
        this.loginService = loginService;
        this.scanner = new Scanner(System.in);
        this.args = new String[2];
    }

    public void startLoginService() {
        TriesValidationServiceImpl.resetTriesService();
        do {
            providingCredentials();
            loginService.provideCredentials(args);
            authentication();
        } while (!loginService.isAuthentication());
        println.print(StringUtilsMyPackage.LOGIN_SUCCESS_MESSAGE.getStringValue());
    }


    public void providingCredentials() {

        println.print(StringUtilsMyPackage.PROVIDE_USERNAME_MESSAGE.getStringValue());
        args[IntUtilsMyPackage.USERNAME_INDEX.getIntValue()] = scanner.next();
        println.print(String.format("Hi %s", args[IntUtilsMyPackage.USERNAME_INDEX.getIntValue()]));
        println.print("");

        println.print(StringUtilsMyPackage.PROVIDE_PASSWORD_MESSAGE.getStringValue());
        char[] password = scanner.next().toCharArray();
        args[IntUtilsMyPackage.PASSWORD_INDEX.getIntValue()] = (String.valueOf(password));

    }

    public void authentication() {
        LoginException loginException = new LoginException();

        try (loginException) {
            loginService.setAuthentication(loginService.authenticationResult());
            if (!loginService.isAuthentication()) {
                throw new LoginException(StringUtilsMyPackage.INVALID_CREDENTIALS_MESSAGE.getStringValue());
            }
        } catch (LoginException e) {
            println.print(e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                println.print("Suppressed: " + t.getMessage());
            }
        } finally {
            if (!loginService.isAuthentication()) {
                TriesValidationServiceImpl.triesValidation();
            }
        }

    }
}
