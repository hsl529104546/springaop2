package com.hsl.annotation;

public class Jack {
    private static Jack ourInstance = new Jack();


    public static Jack getInstance() {
        return ourInstance;
    }

    private Jack() {
    }
}
