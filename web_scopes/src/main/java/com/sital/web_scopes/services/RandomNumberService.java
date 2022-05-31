package com.sital.web_scopes.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class RandomNumberService {

    private final int value;

    public RandomNumberService(){
        this.value = new Random().nextInt(1000);
    }

    public int getValue() {
        return value;
    }
}
