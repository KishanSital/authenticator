package com.github.KishanSital.authenticator.serviceImpl;


import com.github.KishanSital.authenticator.models.UserModel;
import com.github.KishanSital.authenticator.services.AuthenticationRepositoryService;
import com.github.KishanSital.authenticator.services.LoginService;
import com.github.KishanSital.authenticator.utils.IntUtilsMyPackage;

import java.util.Arrays;
import java.util.function.BiFunction;

public final class LoginServiceImpl implements LoginService {
    public boolean isAuthentication;
    private boolean isLoggedIn;
    private UserModel userModel;
    private final AuthenticationRepositoryService authenticationRepositoryService;

    public LoginServiceImpl(UserModel userModel, AuthenticationRepositoryService authenticationRepositoryService) {
        super();
        this.userModel = userModel;
        this.authenticationRepositoryService = authenticationRepositoryService;
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
    public UserModel authenticationResult() {
        UserModel resultingUserModel = authenticateUser((enteredUserModel, foundUserModel) -> {
            if (foundUserModel != null &&
                    Arrays.equals(enteredUserModel.getPassword(), foundUserModel.getPassword()) &&
                    enteredUserModel.getUsername().equalsIgnoreCase(foundUserModel.getUsername())) {
                return foundUserModel;
            } else {
                return null;
            }
        });
        return resultingUserModel;
    }

    @Override
    public UserModel authenticateUser(BiFunction<UserModel, UserModel, UserModel> loggingIn) {
        isLoggedIn = false;
        UserModel foundUser = authenticationRepositoryService.findUserByUsernameAndPassword(userModel);
        UserModel resultingUserModel = loggingIn.apply(userModel, foundUser);
        if (resultingUserModel != null) {
            isLoggedIn = true;
            setAuthentication(isLoggedIn);
        }
        return resultingUserModel;
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
        this.isAuthentication = authentication;
    }
}
