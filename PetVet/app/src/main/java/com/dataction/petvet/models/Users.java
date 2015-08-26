package com.dataction.petvet.models;

import android.graphics.Bitmap;

import lombok.Data;

/**
 * Created by GRavi on 26-08-2015.
 */
@Data
public class Users {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Bitmap photo;
    private int number;

    private static final Users users = new Users();
    public static Users getInstance() {return users;}
}
