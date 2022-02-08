package com.github.KishanSital.authenticator.views;

import com.github.KishanSital.authenticator.exceptions.LoginException;
import com.github.KishanSital.authenticator.models.UserModel;
import com.github.KishanSital.authenticator.serviceImpl.TriesValidationServiceImpl;
import com.github.KishanSital.authenticator.serviceImpl.UserSessionServiceImpl;
import com.github.KishanSital.authenticator.services.LoginService;
import com.github.KishanSital.authenticator.services.PrintMessageService;
import com.github.KishanSital.authenticator.utils.IntUtilsMyPackage;
import com.github.KishanSital.authenticator.utils.StringUtilsMyPackage;

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

    public UserModel startLoginService() {
        TriesValidationServiceImpl.resetTriesService();
        UserModel authenticatedUser = null;
        do {
            providingCredentials();
            loginService.provideCredentials(args);
            authenticatedUser = authentication();
        } while (!loginService.isAuthentication());
        println.print(StringUtilsMyPackage.LOGIN_SUCCESS_MESSAGE.getStringValue());
        UserSessionServiceImpl.LOGIN_USERNAME = authenticatedUser.getUsername();
        UserSessionServiceImpl.LOGIN_PASSWORD = authenticatedUser.getPassword();
        return authenticatedUser;
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

    public UserModel authentication() {
        LoginException loginException = new LoginException();
        UserModel authenticationResult = null;
        try (loginException) {
            authenticationResult = loginService.authenticationResult();
            loginService.setAuthentication(authenticationResult != null);
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

        return authenticationResult;
    }
}
