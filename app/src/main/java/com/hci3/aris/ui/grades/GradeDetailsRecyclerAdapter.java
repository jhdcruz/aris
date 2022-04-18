package com.hci3.aris.ui.grades;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.hci3.aris.R;
import com.hci3.aris.data.model.grades.GradeDetailsCardModel;

import java.util.List;


public class GradeDetailsRecyclerAdapter extends RecyclerView.Adapter<GradeDetailsRecyclerAdapter.ViewHolder> {

    private final List<GradeDetailsCardModel> gradeDetailsModelArrayList;
    private final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    // Constructor
    public GradeDetailsRecyclerAdapter(List<GradeDetailsCardModel> gradeDetailsModelArrayList) {
        this.gradeDetailsModelArrayList = gradeDetailsModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_card_grade_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // to set data to textview
        GradeDetailsCardModel model = gradeDetailsModelArrayList.get(position);

        holder.category.setText(model.getCategory());
        holder.total.setText(model.getTotal());

        // Nested RecyclerView for `GradeDetailsContentRecyclerAdapter`
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.gradeDetailsContent.getContext(), LinearLayoutManager.VERTICAL, false);
        GradeDetailsContentRecyclerAdapter gradeDetailsContentRecyclerAdapter = new GradeDetailsContentRecyclerAdapter(model.getDetailsContent());

        layoutManager.setInitialPrefetchItemCount(model.getDetailsContent().size());

        holder.gradeDetailsContent.setLayoutManager(layoutManager);
        holder.gradeDetailsContent.setAdapter(gradeDetailsContentRecyclerAdapter);
        holder.gradeDetailsContent.setRecycledViewPool(viewPool);

    }

    /**
     * Count the number of card items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return gradeDetailsModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView category;
        private final TextView total;
        private final RecyclerView gradeDetailsContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.details_category);
            total = itemView.findViewById(R.id.details_total);
            gradeDetailsContent = itemView.findViewById(R.id.grade_details_content_list);
        }
    }
}