package com.github.KishanSital.authenticator.repositories;

import com.github.KishanSital.authenticator.models.DatabaseInfo;
import com.github.KishanSital.authenticator.models.UserModel;
import com.github.KishanSital.authenticator.services.AuthenticationRepositoryService;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public final class AuthenticationRepository implements AuthenticationRepositoryService {

    private final DatabaseInfo databaseInfo;

    public AuthenticationRepository(DatabaseInfo databaseInfo) {
        this.databaseInfo = new DatabaseInfo(databaseInfo);
    }

    private Connection establishDBConnection() {

        Properties properties = new Properties();
        properties.setProperty("user", databaseInfo.getDbUser());
        properties.setProperty("password", databaseInfo.getDbPassword());

        try {
            return DriverManager.getConnection(databaseInfo.getDbUrl(), properties);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    @Override
    public UserModel findUserByUsernameAndPassword(UserModel userModel) {
        String findUserSql = "SELECT * FROM "+databaseInfo.getTableName()+" WHERE "
                + databaseInfo.getUserNameColumn()+" = ? AND "
                + databaseInfo.getPasswordColumn()+" = ? ;";

        UserModel userFound = null;

        try (Connection connection = establishDBConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findUserSql)) {
            preparedStatement.setString(1, userModel.getUsername());
            preparedStatement.setString(2, String.valueOf(userModel.getPassword()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userFound = new UserModel.
                        UserModelBuilder().
                        username(resultSet.getString(databaseInfo.getUserNameColumn())).
                        password(resultSet.getString(databaseInfo.getPasswordColumn()).toCharArray())
                        .build();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return userFound;
    }

}
