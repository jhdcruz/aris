package com.hci3.aris.data.model;

import java.text.NumberFormat;
import java.util.Locale;

public class BalanceModel {
    NumberFormat number = NumberFormat.getNumberInstance(Locale.getDefault());

    private final String term;
    private final String receipt;
    private final String date;

    // intentionally use String to preserve 2 decimals
    // and since we'll only use a sample data, so no need for formatters
    private final String amount;
    private final String paid;
    private final String remaining;

    public BalanceModel(String term, String receipt, String date, String amount,
                        String paid) {
        this.term = term;
        this.receipt = receipt;
        this.date = date;
        this.amount = amount;
        this.paid = paid;
        this.remaining = getRemaining();
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
        return amount;
    }

    public String getPaid() {
        return paid;
    }

    public String getRemaining() {
        return String.format(Locale.US, "%.2f",
                Double.parseDouble(amount) - Double.parseDouble(paid));
    }
}
