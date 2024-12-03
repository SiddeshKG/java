package org.example;

public class Allien {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setter is called");
        this.age = age;
    }

    public Allien(){
        System.out.println("object created.... ");
    }
    public void code(){
        System.out.println("coding...");
    }
}
