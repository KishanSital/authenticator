package com.github.KishanSital.authenticator.services;

import com.github.KishanSital.authenticator.models.UserModel;

public interface AuthenticationRepositoryService {
    UserModel findUserByUsernameAndPassword(UserModel userModel);
}
