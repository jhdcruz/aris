package com.hci3.aris.data;

import com.hci3.aris.data.model.BalanceModel;

import java.util.ArrayList;
import java.util.List;

public class BalanceDataSource {

    public List<BalanceModel> getBalance() {

        try {
            List<BalanceModel> balanceList = new ArrayList<>();

            balanceList.add(new BalanceModel("Downpayment", "23239828", "03/11/2022", 3500.00, 350.00));
            balanceList.add(new BalanceModel("1st Installment", "14958679", "04/11/2022", 3500.00, 150.00));
            balanceList.add(new BalanceModel("2nd Installment", "23058375", "05/11/2022", 3500.00, 0.00));
            balanceList.add(new BalanceModel("3rd Installment", "32424234", "06/11/2022", 3500.00, 0.00));
            balanceList.add(new BalanceModel("4th Installment", "53453654", "07/11/2022", 3500.00, 0.00));
            balanceList.add(new BalanceModel("5th Installment", "78678797", "08/11/2022", 3500.00, 0.00));
            balanceList.add(new BalanceModel("6th Installment", "67846463", "09/11/2022", 3500.00, 0.00));
            balanceList.add(new BalanceModel("7th Installment", "23356457", "010/11/2022", 3500.00, 0.00));
            balanceList.add(new BalanceModel("8th Installment", "54758796", "011/11/2022", 3500.00, 0.00));

            return balanceList;
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }
}
