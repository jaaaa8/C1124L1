package com.example.entity;

public class Money {
    private double amount;
    private double rate;
    private String type;

    public Money() {
    }

    public Money(double amount, double rate, String type) {
        this.amount = amount;
        this.rate = rate;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
