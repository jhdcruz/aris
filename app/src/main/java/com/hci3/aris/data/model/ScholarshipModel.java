package com.hci3.aris.data.model;

import java.util.Locale;

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

    public String getAmount() {
        return String.format(Locale.US, "%,.2f", amount);
    }
}
