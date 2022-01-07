package com.github.KishanSital.authenticator.services;

import  com.github.KishanSital.authenticator.annotations.Service;
import  com.github.KishanSital.authenticator.models.UserModel;

@Service("Interface for no constructor reference")
@FunctionalInterface
public interface UserModelEmpty {
    UserModel create();
}
