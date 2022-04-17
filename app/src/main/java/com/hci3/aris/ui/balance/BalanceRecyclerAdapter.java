package com.hci3.aris.ui.balance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.model.BalanceModel;

import java.util.List;
import java.util.Locale;


public class BalanceRecyclerAdapter extends RecyclerView.Adapter<BalanceRecyclerAdapter.ViewHolder> {

    private final List<BalanceModel> balanceModelArrayList;

    // Constructor
    public BalanceRecyclerAdapter(Context context, List<BalanceModel> balanceModelArrayList) {
        this.balanceModelArrayList = balanceModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_card_balance, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // to set data to textview
        BalanceModel model = balanceModelArrayList.get(position);
        holder.term.setText(model.getTerm());
        holder.receipt.setText("OR #: " + model.getReceipt());
        holder.date.setText("Date: " + model.getDate());

        holder.amount.setText("₱" + model.getAmount());
        holder.paid.setText("₱" + model.getPaid());
        holder.remaining.setText("₱" + model.getRemaining());
    }

    /**
     * Count the number of card items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return balanceModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView term;
        private final TextView receipt;
        private final TextView date;

        private final TextView amount;
        private final TextView paid;
        private final TextView remaining;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            term = itemView.findViewById(R.id.balance_term);
            receipt = itemView.findViewById(R.id.balance_receipt);
            date = itemView.findViewById(R.id.balance_date);

            amount = itemView.findViewById(R.id.balance_amount);
            paid = itemView.findViewById(R.id.balance_paid);
            remaining = itemView.findViewById(R.id.balance_remaining);
        }
    }
}