package com.example.onboarding.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telegram")
    private String telegram;

    public Employee() {
        this.id = 0;
        this.name = "";
        this.email = "";
        this.telegram = "";
    }

    public Employee(int id, String name, String email, String telegram) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telegram = telegram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    @Override
    public String toString() {
        return this.id + this.name + this.email + this.telegram;
    }
}
