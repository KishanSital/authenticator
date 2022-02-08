package com.github.KishanSital.authenticator.application;

import com.github.KishanSital.authenticator.models.DatabaseInfo;
import com.github.KishanSital.authenticator.models.UserModel;
import com.github.KishanSital.authenticator.repositories.AuthenticationRepository;
import com.github.KishanSital.authenticator.serviceImpl.LoginServiceImpl;
import com.github.KishanSital.authenticator.services.AuthenticationRepositoryService;
import com.github.KishanSital.authenticator.services.LoginService;
import com.github.KishanSital.authenticator.services.UserModelEmpty;
import com.github.KishanSital.authenticator.views.LoginView;

public final class MyPackageApplication {
    public static UserModel startLoginService(DatabaseInfo databaseInfo) {

        if (databaseInfo == null ||
                databaseInfo.getDbPassword() == null ||
                databaseInfo.getDbUrl() == null ||
                databaseInfo.getDbUser() == null ||
                databaseInfo.getPasswordColumn() == null ||
                databaseInfo.getTableName() == null ||
                databaseInfo.getUserNameColumn() == null) {
            System.out.println("\n Something went wrong please try again later.");
            System.exit(0);
        }


        UserModelEmpty userModelEmpty = UserModel::new;

        AuthenticationRepositoryService authenticationRepositoryService = new AuthenticationRepository(databaseInfo);
        LoginService loginServiceImpl = new LoginServiceImpl(userModelEmpty.create(), authenticationRepositoryService);
         return new LoginView(loginServiceImpl).startLoginService();
    }
}
