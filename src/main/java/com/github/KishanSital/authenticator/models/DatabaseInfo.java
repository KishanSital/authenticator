package com.github.KishanSital.authenticator.models;

public final class DatabaseInfo extends Object {
    String dbUrl;
    String dbUser;
    String dbPassword;
    String tableName;
    String userNameColumn;
    String passwordColumn;

    public DatabaseInfo(String dbUrl,
                        String dbUser,
                        String dbPassword,
                        String tableName,
                        String userNameColumn,
                        String passwordColumn) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.tableName = tableName;
        this.userNameColumn = userNameColumn;
        this.passwordColumn = passwordColumn;
    }

    public DatabaseInfo(DatabaseInfo databaseInfo) {
        this.dbUrl = databaseInfo.dbUrl;
        this.dbUser = databaseInfo.dbUser;
        this.dbPassword = databaseInfo.dbPassword;
        this.tableName = databaseInfo.tableName;
        this.userNameColumn = databaseInfo.userNameColumn;
        this.passwordColumn = databaseInfo.passwordColumn;
    }

    public DatabaseInfo(DatabaseInfoBuilder databaseInfoBuilder) {
        this.dbUrl = databaseInfoBuilder.dbUrl;
        this.dbUser = databaseInfoBuilder.dbUser;
        this.dbPassword = databaseInfoBuilder.dbPassword;
        this.tableName = databaseInfoBuilder.tableName;
        this.userNameColumn = databaseInfoBuilder.userNameColumn;
        this.passwordColumn = databaseInfoBuilder.passwordColumn;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserNameColumn() {
        return userNameColumn;
    }

    public void setUserNameColumn(String userNameColumn) {
        this.userNameColumn = userNameColumn;
    }

    public String getPasswordColumn() {
        return passwordColumn;
    }

    public void setPasswordColumn(String passwordColumn) {
        this.passwordColumn = passwordColumn;
    }

    public static class DatabaseInfoBuilder {

        String dbUrl;
        String dbUser;
        String dbPassword;
        String tableName;
        String userNameColumn;
        String passwordColumn;

        public DatabaseInfo.DatabaseInfoBuilder dbUrl(String dbUrl) {
            this.dbUrl = dbUrl;
            return this;
        }

        public DatabaseInfo.DatabaseInfoBuilder dbUser(String dbUser) {
            this.dbUser = dbUser;
            return this;
        }

        public DatabaseInfo.DatabaseInfoBuilder dbPassword(String dbPassword) {
            this.dbPassword = dbPassword;
            return this;
        }

        public DatabaseInfo.DatabaseInfoBuilder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public DatabaseInfo.DatabaseInfoBuilder userNameColumn(String userNameColumn) {
            this.userNameColumn = userNameColumn;
            return this;
        }

        public DatabaseInfo.DatabaseInfoBuilder passwordColumn(String passwordColumn) {
            this.passwordColumn = passwordColumn;
            return this;
        }

        public DatabaseInfo build() {
            DatabaseInfo databaseInfo = new DatabaseInfo(this);
            return databaseInfo;
        }

    }

}
