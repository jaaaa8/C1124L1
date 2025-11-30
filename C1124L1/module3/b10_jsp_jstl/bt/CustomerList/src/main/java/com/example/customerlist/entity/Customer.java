package com.example.customerlist.entity;

public class Customer {
    private int id;
    private String name;
    private boolean gender;
    private float score;

    public Customer() {
    }

    public Customer(boolean gender, int id, String name, float score) {
        this.gender = gender;
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
