package com.kgs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "roll")
    private int roll_num;

    @Column(name = "student_name")
    private String name;
    @Column(name = "email")
    private String email;
    private int marks;


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


    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_num=" + roll_num +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", marks=" + marks +
                '}';
    }

    public Student(int roll_num, String name, String email, int marks) {
        this.roll_num = roll_num;
        this.name = name;
        this.email = email;
        this.marks = marks;
    }
}
