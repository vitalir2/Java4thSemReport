package com.example.finalprj.model;

public class RegistrationForm {
    private final String name;
    private final String password;

    public RegistrationForm(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
