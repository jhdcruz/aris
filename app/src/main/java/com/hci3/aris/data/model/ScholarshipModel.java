package com.hci3.aris.data.model;

public class ScholarshipModel {

    private final String name;
    private final String date;
    private final double amount;

    public ScholarshipModel(String name, String date, double amount) {
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
