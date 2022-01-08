package com.github.KishanSital.authenticator.services;

import com.github.KishanSital.authenticator.models.UserModel;
import com.github.KishanSital.authenticator.annotations.Service;

@Service("Interface for constructor reference with arguments")
@FunctionalInterface
public interface UserModelWithArguments {
    UserModel create(Long userId, String username, char[] password);
}
