package com.hci3.aris.ui.grades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.model.CourseModel;

import java.util.List;


public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.ViewHolder> {

    private final List<CourseModel> courseModelArrayList;

    // Constructor
    public GradesAdapter(Context context, List<CourseModel> courseModelArrayList) {
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseCode;
        private final TextView courseName;
        private final TextView courseUnits;
        private final TextView courseGpa;
        private final TextView gradePrelim;
        private final TextView gradeMidterm;
        private final TextView gradeFinal;

        public ViewHolder(@NonNull View itemView) {
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

            Button gradeDetails = itemView.findViewById(R.id.grade_details);
            gradeDetails.setOnClickListener(l ->
                    Navigation.findNavController(l).navigate(R.id.action_navigation_grades_to_subnav_grade_details_list)
            );
        }
    }
}