package com.hci3.aris.ui.grades;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hci3.aris.R;
import com.hci3.aris.data.model.SemesterModel;

import java.util.List;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.ViewHolder> {

    private final List<SemesterModel> semesterModelArrayList;

    public SemesterAdapter(Context context, List<SemesterModel> semesterModelArrayList) {
        this.semesterModelArrayList = semesterModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_semester, parent, false);
        return new SemesterAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SemesterModel model = semesterModelArrayList.get(position);

        holder.sem.setText(model.getSemester());
        holder.semSy.setText(model.getSchoolYear());
        holder.semGpa.setText(String.valueOf(model.getSemGpa()));
        holder.unitsEarned.setText(String.valueOf(model.getUnitsEarned()));
        holder.unitsEnrolled.setText(String.valueOf(model.getUnitsEnrolled()));
        holder.courseCount.setText(String.valueOf(model.getCourseCount()));
    }

    @Override
    public int getItemCount() {
        return semesterModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView sem;
        private final TextView semSy;
        private final TextView courseCount;
        private final TextView unitsEarned;
        private final TextView unitsEnrolled;
        private final TextView semGpa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sem = itemView.findViewById(R.id.sem);
            semSy = itemView.findViewById(R.id.sem_sy);
            courseCount = itemView.findViewById(R.id.course_count);
            unitsEarned = itemView.findViewById(R.id.units_earned);
            unitsEnrolled = itemView.findViewById(R.id.units_enrolled);
            semGpa = itemView.findViewById(R.id.sem_gpa);

            itemView.setOnClickListener(l ->
                    Navigation.findNavController(l).navigate(R.id.action_subnav_semester_to_subnav_grade_list)
            );
        }
    }
}