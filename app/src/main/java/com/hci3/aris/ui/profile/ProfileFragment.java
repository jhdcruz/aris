package com.hci3.aris.ui.profile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.hci3.aris.R;
import com.hci3.aris.data.CourseDataSource;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        /*
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CourseDataSource dataSource = new CourseDataSource();
        ProfileRecyclerAdapter courseAdapter = new ProfileRecyclerAdapter(getContext(), dataSource.getCourses());

        RecyclerView recyclerViewGrid = view.findViewById(R.id.enrolled_courses_grid);
        RecyclerView recyclerViewList = view.findViewById(R.id.enrolled_courses_list);
        RecyclerView prevRecyclerViewGrid = view.findViewById(R.id.previous_courses_grid);
        RecyclerView prevRecyclerViewList = view.findViewById(R.id.previous_courses_list);

        // Change view between linear and grid based on viewport
        if (recyclerViewGrid != null) {
            recyclerViewGrid.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
            prevRecyclerViewGrid.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
            recyclerViewGrid.setAdapter(courseAdapter);
            prevRecyclerViewGrid.setAdapter(courseAdapter);
        } else {
            recyclerViewList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            prevRecyclerViewList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerViewList.setAdapter(courseAdapter);
            prevRecyclerViewList.setAdapter(courseAdapter);
        }

        // Count total courses
        MaterialTextView enrolledCourses = view.findViewById(R.id.enrolled_count);
        MaterialTextView prevEnrolledCourses = view.findViewById(R.id.previous_enrolled_count);
        enrolledCourses.setText("(" + courseAdapter.getItemCount() + ")");
        prevEnrolledCourses.setText("(" + courseAdapter.getItemCount() + ")");

        // Hide/show enrolled courses when hide button is clicked
        // Using if-else contradicts each other for some reason
        // so we go with different button route instead
        Button hideEnrolled = view.findViewById(R.id.hide_enrolled);
        Button showEnrolled = view.findViewById(R.id.show_enrolled);
        hideEnrolled.setOnClickListener(l -> {
            if (recyclerViewList != null) {
                recyclerViewList.setVisibility(View.GONE);
            } else {
                recyclerViewGrid.setVisibility(View.GONE);
            }

            hideEnrolled.setVisibility(View.GONE);
            showEnrolled.setVisibility(View.VISIBLE);
        });
        showEnrolled.setOnClickListener(l -> {
            if (recyclerViewList != null) {
                recyclerViewList.setVisibility(View.VISIBLE);
            } else {
                recyclerViewGrid.setVisibility(View.VISIBLE);
            }

            hideEnrolled.setVisibility(View.VISIBLE);
            showEnrolled.setVisibility(View.GONE);

        });

        // Hide/show previously enrolled courses when hide button is clicked
        Button hidePrevEnrolled = view.findViewById(R.id.hide_previous_courses);
        Button showPrevEnrolled = view.findViewById(R.id.show_previous_courses);
        hidePrevEnrolled.setOnClickListener(l -> {
            if (prevRecyclerViewList != null) {
                prevRecyclerViewList.setVisibility(View.GONE);
            } else {
                prevRecyclerViewGrid.setVisibility(View.GONE);
            }

            hidePrevEnrolled.setVisibility(View.GONE);
            showPrevEnrolled.setVisibility(View.VISIBLE);
        });
        showPrevEnrolled.setOnClickListener(l -> {
            if (prevRecyclerViewList != null) {
                prevRecyclerViewList.setVisibility(View.VISIBLE);
            } else {
                prevRecyclerViewGrid.setVisibility(View.VISIBLE);
            }

            hidePrevEnrolled.setVisibility(View.VISIBLE);
            showPrevEnrolled.setVisibility(View.GONE);
        });
    }
}