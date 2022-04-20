package com.hci3.aris.ui.schedule;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textview.MaterialTextView;
import com.hci3.aris.R;
import com.hci3.aris.data.CourseDataSource;

public class ScheduleFragment extends Fragment {

    public ScheduleFragment() {
        /*
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CourseDataSource dataSource = new CourseDataSource();
        ScheduleRecyclerAdapter scheduleAdapter = new ScheduleRecyclerAdapter(getContext(), dataSource.getCourses());

        RecyclerView recyclerViewGrid = view.findViewById(R.id.schedule_grid);
        RecyclerView recyclerViewList = view.findViewById(R.id.schedule_list);

        if (recyclerViewGrid != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
            recyclerViewGrid.setLayoutManager(gridLayoutManager);
            recyclerViewGrid.setAdapter(scheduleAdapter);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerViewList.setLayoutManager(linearLayoutManager);
            recyclerViewList.setAdapter(scheduleAdapter);
        }

        MaterialTextView enrolledCourses = view.findViewById(R.id.sched_today);
        enrolledCourses.setText("(" + scheduleAdapter.getItemCount() + ")");

        Button viewAll = view.findViewById(R.id.schedule_view_all);
        viewAll.setOnClickListener(l ->
                Navigation.findNavController(l).navigate(R.id.action_navigation_schedule_main_to_subnav_schedule_plot)
        );
    }

}