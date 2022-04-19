package com.hci3.aris.data.model;

import java.util.Locale;

public class EnrollmentModel {

    private final String sem;
    private final String receipt;
    private final String date;

    private final double amount;
    private final double paid;

    public EnrollmentModel(String sem, String receipt, String date, double amount,
                        double paid) {
        this.sem =  sem;
        this.receipt = receipt;
        this.date = date;
        this.amount = amount;
        this.paid = paid;
        String remaining = getRemaining();
    }

    public String getSem() {
        return sem;
    }

    public String getOR() {
        return receipt;
    }

    public String getDates() {
        return date;
    }

    public String getAmounts() {
        return String.format(Locale.US, "%,.2f", amount);
    }

    public String getPayment() {
        return String.format(Locale.US, "%,.2f", paid);
    }

    public String getRemaining() {
        return String.format(Locale.US, "%,.2f",
                amount - paid);
    }
}

