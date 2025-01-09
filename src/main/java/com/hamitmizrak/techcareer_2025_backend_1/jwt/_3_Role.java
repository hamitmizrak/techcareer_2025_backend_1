package com.hamitmizrak.techcareer_2025_backend_1.jwt;

public enum _3_Role {
    USER(1,"user"),WRITER(2,"writer"),ADMIN(3,"admin");

    private final int key;
    private final String value;

    // private Constructor
   private _3_Role(int key, String value) {
        this.key = key;
        this.value = value;
    }

    // GETTER AND SETTER
    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
