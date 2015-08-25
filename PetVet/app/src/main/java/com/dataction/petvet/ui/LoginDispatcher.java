package com.dataction.petvet.ui;

import com.dataction.petvet.LoginActivity;

/**
 * Created by GRavi on 25-08-2015.
 */
public class LoginDispatcher extends PetVetLoginDispatcher {
    @Override
    protected Class<?> getTargetClass() {
        return LoginActivity.class;
    }
}
