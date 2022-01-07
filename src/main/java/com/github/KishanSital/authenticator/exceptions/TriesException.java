package com.github.KishanSital.authenticator.exceptions;


public final class TriesException extends Exception implements AutoCloseable {

    public TriesException() {
        super();
    }

    public TriesException(String message) {
        super(message);
    }

    public TriesException(Exception exception) {
        super(exception);
    }

    @Override
    public void close()  {
        System.out.println("Closing try with resources for tries exception");

    }
}
