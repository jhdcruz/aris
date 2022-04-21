package com.hci3.aris.ui.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.model.CourseModel;

import java.util.List;

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<ProfileRecyclerAdapter.ViewHolder> {

    private final List<CourseModel> courseModelArrayList;
    Context context;

    // Constructor
    public ProfileRecyclerAdapter(Context context, List<CourseModel> courseModelArrayList) {
        this.courseModelArrayList = courseModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_card_course, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // to set data to textview
        CourseModel model = courseModelArrayList.get(position);

        holder.courseSection.setText(model.getCourseSection());
        holder.courseCode.setText(model.getCourseCode());
        holder.courseName.setText(model.getCourseName());
        holder.courseProf.setText("Prof. " + model.getCourseProf());
        holder.courseTime.setText(model.getCourseTime());
        holder.courseSched.setText(model.getCourseSched());
        holder.courseRoom.setText(model.getCourseRoom());
        holder.courseUnits.setText("Units: " + model.getCourseUnits());
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
        private final TextView courseSection;
        private final TextView courseCode;
        private final TextView courseName;
        private final TextView courseProf;
        private final TextView courseTime;
        private final TextView courseSched;
        private final TextView courseRoom;
        private final TextView courseUnits;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Course details
            courseSection = itemView.findViewById(R.id.course_section);
            courseCode = itemView.findViewById(R.id.course_code);
            courseName = itemView.findViewById(R.id.course_name);
            courseProf = itemView.findViewById(R.id.course_prof);
            courseTime = itemView.findViewById(R.id.course_time);
            courseSched = itemView.findViewById(R.id.course_sched);
            courseRoom = itemView.findViewById(R.id.course_room);
            courseUnits = itemView.findViewById(R.id.course_units);
        }
    }
}