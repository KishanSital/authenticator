package com.github.KishanSital.authenticator.serviceImpl;


import com.github.KishanSital.authenticator.models.UserModel;
import com.github.KishanSital.authenticator.services.LoginService;
import com.github.KishanSital.authenticator.utils.IntUtilsMyPackage;

import java.util.Arrays;
import java.util.function.Predicate;

public final class LoginServiceImpl implements LoginService {
    public boolean isAuthentication;
    private boolean isLoggedIn;
    private UserModel userModel;

    public LoginServiceImpl(UserModel userModel) {
        super();
        this.userModel = userModel;
        init();
    }

    public void init() {
    }

    @Override
    public void provideCredentials(String... args) {
        userModel.setUsername(args[IntUtilsMyPackage.USERNAME_INDEX.getIntValue()]);
        char[] chars = args[IntUtilsMyPackage.PASSWORD_INDEX.getIntValue()].toCharArray();
        userModel.setPassword(chars);
    }

    @Override
    public boolean authenticationResult() {
        isAuthentication = authenticateUser(k -> {
            if ((UserSessionServiceImpl.LOGIN_USERNAME.equalsIgnoreCase(k.getUsername())) &&
                    (Arrays.equals(UserSessionServiceImpl.LOGIN_PASSWORD, k.getPassword()))) {
                return true;
            } else {
                return false;
            }
        });
        return isAuthentication;
    }

    @Override
    public boolean authenticateUser(Predicate<UserModel> loggingIn) {
        isLoggedIn = false;
        if (loggingIn.test(userModel)) {
            isLoggedIn = true;
        }
        return isLoggedIn;
    }

    @Override
    public String getLoggedInUser() {
        return UserSessionServiceImpl.LOGIN_USERNAME;
    }

    @Override
    public boolean isAuthentication() {
        return isAuthentication;
    }

    @Override
    public void setAuthentication(boolean authentication) {

    }
}
