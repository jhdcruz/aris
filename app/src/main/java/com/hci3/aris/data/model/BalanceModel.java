package com.hci3.aris.data.model;

import java.util.Locale;

public class BalanceModel {

    private final String term;
    private final String receipt;
    private final String date;

    private final double amount;
    private final double paid;

    public BalanceModel(String term, String receipt, String date, double amount,
                        double paid) {
        this.term = term;
        this.receipt = receipt;
        this.date = date;
        this.amount = amount;
        this.paid = paid;
    }

    public String getTerm() {
        return term;
    }

    public String getReceipt() {
        return receipt;
    }

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return String.format(Locale.US, "%,.2f", amount);
    }

    public String getPaid() {
        return String.format(Locale.US, "%,.2f", paid);
    }

    public String getRemaining() {
        return String.format(Locale.US, "%,.2f",
                amount - paid);
    }
}
