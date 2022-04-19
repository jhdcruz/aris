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
import com.hci3.aris.data.model.EnrollmentModel;

import java.util.List;

public class EnrollmentRecyclerAdapter extends RecyclerView.Adapter<EnrollmentRecyclerAdapter.ViewHolder> {

    private final List<EnrollmentModel> enrollModelArrayList;

    // Constructor
    public EnrollmentRecyclerAdapter(Context context, List<EnrollmentModel> enrollModelArrayList) {
        this.enrollModelArrayList = enrollModelArrayList;
    }

    @NonNull
    @Override
    public EnrollmentRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_card_enrollment, parent, false);
        return new EnrollmentRecyclerAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull EnrollmentRecyclerAdapter.ViewHolder holder, int position) {
        // to set data to textview
        EnrollmentModel model = enrollModelArrayList.get(position);
        holder.sem.setText(model.getSem());
        holder.receipt.setText("OR #: " + model.getOR());
        holder.date.setText("Date: " + model.getDates());

        holder.amount.setText("₱" + model.getAmounts());
        holder.paid.setText("₱" + model.getPayment());
        holder.remaining.setText("₱" + model.getRemaining());
    }

    /**
     * Count the number of card items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return enrollModelArrayList.size();
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sem = itemView.findViewById(R.id.installment);
            receipt = itemView.findViewById(R.id.reciepts);
            date = itemView.findViewById(R.id.dates);

            amount = itemView.findViewById(R.id.due_amount);
            paid = itemView.findViewById(R.id.paid_amount);
            remaining = itemView.findViewById(R.id.balance_amount);
        }
    }
}

