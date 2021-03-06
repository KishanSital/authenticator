package com.github.KishanSital.authenticator.services;

import com.github.KishanSital.authenticator.annotations.Service;
import com.github.KishanSital.authenticator.serviceImpl.TriesValidationServiceImpl;

@Service
public abstract interface MenuService {
    String toString();
    int hashCode();
    boolean equals(Object object);
    default void menuOptions() {}
    default void displayMenu() {}
    default void init() {}
    default void printOutMenuOptions(){};

    default void resetAllValidationServices() {
        reset();
    }
    private static void reset(){
        TriesValidationServiceImpl.resetTriesService();
    }

}
