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
import com.hci3.aris.data.model.ScholarshipModel;

import java.util.List;


public class ScholarshipRecyclerAdapter extends RecyclerView.Adapter<ScholarshipRecyclerAdapter.ViewHolder> {

    private final List<ScholarshipModel> scholarshipModelArrayList;

    // Constructor
    public ScholarshipRecyclerAdapter(Context context, List<ScholarshipModel> scholarshipModelArrayList) {
        this.scholarshipModelArrayList = scholarshipModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_card_scholarship, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // to set data to textview
        ScholarshipModel model = scholarshipModelArrayList.get(position);
        holder.name.setText(model.getName());
        holder.date.setText("Date: " + model.getDate());
        holder.amount.setText("₱" + model.getAmount());
    }

    /**
     * Count the number of card items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return scholarshipModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView date;
        private final TextView amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.scholarship_name);
            date = itemView.findViewById(R.id.scholarship_date);
            amount = itemView.findViewById(R.id.scholarship_amount);
        }
    }
}