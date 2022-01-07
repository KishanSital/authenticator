package com.github.KishanSital.authenticator.application;

import  com.github.KishanSital.authenticator.models.UserModel;
import  com.github.KishanSital.authenticator.serviceImpl.LoginServiceImpl;
import  com.github.KishanSital.authenticator.serviceImpl.UserSessionServiceImpl;
import  com.github.KishanSital.authenticator.services.LoginService;
import  com.github.KishanSital.authenticator.services.UserModelEmpty;
import  com.github.KishanSital.authenticator.views.LoginView;

public final class  com.github.KishanSital.authenticatorApplication {
    public static void startLoginService(UserModel expectedUser) {

        if (expectedUser == null) {
            System.out.println("\n Something went wrong please try again later.");
            System.exit(0);
        }

        //Constructor reference
        UserModelEmpty userModelEmpty = UserModel::new;

        new UserSessionServiceImpl(expectedUser);
        LoginService loginServiceImpl = new LoginServiceImpl(userModelEmpty.create());
        new LoginView(loginServiceImpl).startLoginService();
    }
}
