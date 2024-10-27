package com.itproger.collegelab03;

import androidx.annotation.NonNull;

public class Chisla {
    String name;
    float coef;

    public Chisla(String name, float coef)
    {
        this.name = name;
        this.coef = coef;
    }

    @NonNull
    @Override
    public String toString()
    {
        return name;
    }
}
