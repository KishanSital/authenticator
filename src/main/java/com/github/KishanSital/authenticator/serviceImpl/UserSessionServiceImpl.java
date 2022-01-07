package com.github.KishanSital.authenticator.serviceImpl;


import  com.github.KishanSital.authenticator.models.UserModel;
import  com.github.KishanSital.authenticator.services.UserSessionService;

public  final class UserSessionServiceImpl implements UserSessionService {
    public static String LOGIN_USERNAME;
    public static char [] LOGIN_PASSWORD;
    public static Long USER_ID;

    public UserSessionServiceImpl(UserModel expectedUser) {
        USER_ID = expectedUser.getUserId();
        LOGIN_USERNAME = expectedUser.getUsername();
        LOGIN_PASSWORD = expectedUser.getPassword();
    }


}
