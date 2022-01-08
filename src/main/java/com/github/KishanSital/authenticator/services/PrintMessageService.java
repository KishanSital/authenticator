package com.github.KishanSital.authenticator.services;

import com.github.KishanSital.authenticator.annotations.Service;

@Service
@FunctionalInterface
public interface PrintMessageService {
    void print(String message);
    String toString();
}
