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
import com.hci3.aris.data.model.EnrollmentModel;

import java.util.List;

public class EnrollmentRecyclerAdapter extends RecyclerView.Adapter<EnrollmentRecyclerAdapter.ViewHolder> {

    private final List<EnrollmentModel> enrollmentModelArrayList;

    // Constructor
    public EnrollmentRecyclerAdapter(Context context, List<EnrollmentModel> enrollmentModelArrayList) {
        this.enrollmentModelArrayList = enrollmentModelArrayList;
    }

    @NonNull
    @Override
    public EnrollmentRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_card_balance, parent, false);
        return new EnrollmentRecyclerAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull EnrollmentRecyclerAdapter.ViewHolder holder, int position) {
        // to set data to textview
        EnrollmentModel model = enrollmentModelArrayList.get(position);
        holder.sem.setText(model.getSem());
        holder.receipt.setText("OR #: " + model.getReceipt());
        holder.date.setText("Date: " + model.getDates());

        holder.amount.setText("₱" + model.getAmounts());
        holder.paid.setText("₱" + model.getPayment());
        holder.remaining.setText("₱" + model.getRemaining());
        holder.paymentType.setText(model.isFull());
    }

    /**
     * Count the number of card items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return enrollmentModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView sem;
        private final TextView receipt;
        private final TextView date;

        private final TextView amount;
        private final TextView paid;
        private final TextView remaining;
        private final TextView paymentType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sem = itemView.findViewById(R.id.balance_term);
            receipt = itemView.findViewById(R.id.balance_receipt);
            date = itemView.findViewById(R.id.balance_date);

            amount = itemView.findViewById(R.id.balance_amount);
            paid = itemView.findViewById(R.id.balance_paid);
            remaining = itemView.findViewById(R.id.balance_remaining);

            paymentType = itemView.findViewById(R.id.balance_payment_type);
            paymentType.setVisibility(View.VISIBLE);
        }
    }
}

