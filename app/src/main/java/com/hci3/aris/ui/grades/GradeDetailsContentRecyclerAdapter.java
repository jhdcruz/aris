package com.hci3.aris.ui.grades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.model.grades.GradeDetailsContentModel;

import java.util.List;


public class GradeDetailsContentRecyclerAdapter extends RecyclerView.Adapter<GradeDetailsContentRecyclerAdapter.ViewHolder> {

    private final List<GradeDetailsContentModel> gradeDetailsContentList;

    // Constructor
    public GradeDetailsContentRecyclerAdapter(List<GradeDetailsContentModel> gradeDetailsContentList) {
        this.gradeDetailsContentList = gradeDetailsContentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_grade_details_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // to set data to textview
        GradeDetailsContentModel model = gradeDetailsContentList.get(position);

        holder.task.setText(model.getTask());
        holder.score.setText(model.getScore());
        holder.grade.setText(model.getGrade());
    }

    /**
     * Count the number of card items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return gradeDetailsContentList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView task;
        private final TextView score;
        private final TextView grade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            task = itemView.findViewById(R.id.details_content_task);
            score = itemView.findViewById(R.id.details_content_score);
            grade = itemView.findViewById(R.id.details_content_grade);
        }
    }
}