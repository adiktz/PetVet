package com.dataction.petvet.models;

import android.graphics.Bitmap;

import java.util.Date;

import lombok.Data;

/**
 * Created by GRavi on 26-08-2015.
 */
@Data
public class Pets {
    private String name;
    private String vet;
    private String vetId;
    private String breed;
    private String specie;
    private Date dateOfBirth;
    private Bitmap photo;

    private static final Pets pets = new Pets();
    public static Pets getInstance() {return pets;}
}
