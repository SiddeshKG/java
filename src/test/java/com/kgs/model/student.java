package com.kgs.model;

public class student {

    private int roll_num;
    private String name;

    public void setRoll_num(int roll_num) {
        this.roll_num = roll_num;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_num() {
        return roll_num;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String email;

    public student(int roll_num, String name, String email) {
        this.roll_num = roll_num;
        this.name = name;
        this.email = email;
    }
}
