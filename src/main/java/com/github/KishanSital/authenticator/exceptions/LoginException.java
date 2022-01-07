package com.github.KishanSital.authenticator.exceptions;

public final class LoginException extends Exception implements AutoCloseable {

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(Exception exception) {
        super(exception);
    }

    @Override
    public void close(){
        /*System.out.println("Closing try with resources for login");*/
    }
}
