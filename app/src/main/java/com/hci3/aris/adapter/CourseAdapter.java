package com.hci3.aris.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.model.CourseModel;

import java.util.ArrayList;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.Viewholder> {

    private final ArrayList<CourseModel> courseModelArrayList;

    // Constructor
    public CourseAdapter(Context context, ArrayList<CourseModel> courseModelArrayList) {
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public CourseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_course, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.Viewholder holder, int position) {
        // to set data to textview
        CourseModel model = courseModelArrayList.get(position);
        holder.courseCode.setText(model.getCourseCode());
        holder.courseName.setText(model.getCourseName());
        holder.courseUnits.setText(String.valueOf(model.getCourseUnits()));
        holder.courseGpa.setText(String.valueOf(model.getCourseGpa()));

        holder.gradePrelim.setText(String.valueOf(model.getGradePrelim()));
        holder.gradeMidterm.setText(String.valueOf(model.getGradeMidterm()));
        holder.gradeFinal.setText(String.valueOf(model.getGradeFinal()));
    }

    /**
     * Count the number of card items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class Viewholder extends RecyclerView.ViewHolder {
        private final TextView courseCode;
        private final TextView courseName;
        private final TextView courseUnits;
        private final TextView courseGpa;
        private final TextView gradePrelim;
        private final TextView gradeMidterm;
        private final TextView gradeFinal;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            // Course details
            courseCode = itemView.findViewById(R.id.course_code);
            courseName = itemView.findViewById(R.id.course_name);
            courseUnits = itemView.findViewById(R.id.course_units);
            courseGpa = itemView.findViewById(R.id.course_gpa);

            // Course grades
            gradePrelim = itemView.findViewById(R.id.prelim_grade);
            gradeMidterm = itemView.findViewById(R.id.midterm_grade);
            gradeFinal = itemView.findViewById(R.id.finals_grade);
        }
    }
}