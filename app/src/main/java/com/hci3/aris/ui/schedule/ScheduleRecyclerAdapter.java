package com.hci3.aris.ui.schedule;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.model.CourseModel;

import java.util.List;

public class ScheduleRecyclerAdapter extends RecyclerView.Adapter<ScheduleRecyclerAdapter.ViewHolder> {

    private final List<CourseModel> scheduleModelArrayList;
    Context context;

    // Constructor
    public ScheduleRecyclerAdapter(Context context, List<CourseModel> courseModelArrayList) {
        this.scheduleModelArrayList = courseModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_card_schedule, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // to set data to textview
        CourseModel model = scheduleModelArrayList.get(position);

        holder.courseCode.setText(model.getCourseCode());
        holder.courseName.setText(model.getCourseName());
        holder.courseSched.setText(model.getCourseSched());
        holder.courseRoom.setText(model.getCourseRoom());
        holder.courseProf.setText("Prof. " + model.getCourseProf());

        holder.courseContact.setOnClickListener(l -> {
            Uri uri = Uri.parse("https://tip.instructure.com/courses/" + model.getCourseCanvasCode() + "/assignments");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        });

        // Redirect to Canvas course conference
        //  through the app (if installed) or through a browser
        holder.courseConference.setOnClickListener(l -> {
            Uri uri = Uri.parse("https://tip.instructure.com/courses/" + model.getCourseCanvasCode() + "/conferences");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        });
    }

    /**
     * Count the number of card items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return scheduleModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseCode;
        private final TextView courseName;
        private final TextView courseSched;
        private final TextView courseRoom;
        private final TextView courseProf;

        private final Button courseContact;
        private final Button courseConference;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Course details
            courseCode = itemView.findViewById(R.id.course_code);
            courseName = itemView.findViewById(R.id.course_name);
            courseProf = itemView.findViewById(R.id.course_prof);
            courseSched = itemView.findViewById(R.id.course_sched);
            courseRoom = itemView.findViewById(R.id.course_room);

            courseContact = itemView.findViewById(R.id.course_contact);
            courseConference = itemView.findViewById(R.id.course_conference);
        }
    }
}